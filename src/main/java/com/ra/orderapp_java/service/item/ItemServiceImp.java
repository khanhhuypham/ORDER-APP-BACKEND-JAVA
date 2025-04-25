package com.ra.orderapp_java.service.item;


import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.item.ItemQueryDTO;
import com.ra.orderapp_java.model.dto.item.ItemRequestDTO;
import com.ra.orderapp_java.model.dto.item.ItemResponseDTO;
import com.ra.orderapp_java.model.entity.*;

import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnChildrenItem;
import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.repository.*;
import com.ra.orderapp_java.repository.joinEntity.ItemOnChildrenItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Any;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ItemServiceImp implements ItemService {
    public final ItemRepository itemRepo;
    private final ChildrenItemRepository childrenItemRepo;
    private final UnitRepository unitRepo;
    private final CategoryRepository categoryRepo;
    private final PrinterRepository printerRepo;
    private final ItemOnChildrenItemRepository itemOnChildrenItemRepo;


    @Override
    public PaginationDTO<ItemResponseDTO> findAll(ItemQueryDTO dto) {

        List<ItemResponseDTO> list = new ArrayList();
        Pageable pageable  = PageRequest.of(dto.getPage() - 1, dto.getLimit());

        List<CATEGORY_TYPE> category_type = null;

        if (dto.getCategory_type() != null){
            category_type = dto.getCategory_type().stream()
                .map(CATEGORY_TYPE::fromValue)
                .collect(Collectors.toList());
        }

        Page<Item> result = itemRepo.findAllByCondition(
            category_type,
            dto.getCategory_id(),
            dto.getOut_of_stock(),
            dto.getSearch_key(),
            pageable
        );

        for(Item item : result) {
            List<ChildrenItem> childrenItemList = childrenItemRepo.findByParentId(item.getId());
            list.add(new ItemResponseDTO(item,childrenItemList));
        }
        return PaginationDTO.input(list,result);
    }


    @Transactional
    @Override
    public ItemResponseDTO create(Long id, ItemRequestDTO dto) {

        Category category = null; // Consider orElseThrow for better error handling
        if (dto.getCategory_id() != null){
            category = categoryRepo.findById(dto.getCategory_id()).orElse(null);
        }

        Unit unit = unitRepo.findById(dto.getUnit_id()).orElse(null);
        Printer printer = printerRepo.findById(dto.getPrinter_id()).orElse(null);

        Item.ItemBuilder itemBuilder = Item.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .image(dto.getImage())
                .category_type(dto.getCategory_type())
                .description(dto.getDescription())
                .sell_by_weight(dto.getSell_by_weight())
                .category(category)
                .unit(unit)
                .printer(printer);

        Item itemToSave;
        if (id != null) {
            Item foundItem = itemRepo.findById(id).orElse(null); //Consider orElseThrow
            if (foundItem == null) {
                // Handle the case where the item with the given ID isn't found.
                // You might throw an exception, return a specific error response, etc.
                return null; // Or throw an exception.
            }
            itemToSave = itemBuilder.id(foundItem.getId()).out_of_stock(foundItem.getOut_of_stock()).build();
        } else {
            itemToSave = itemBuilder.out_of_stock(false).build(); //default out of stock to false.
        }

        Item savedItem = itemRepo.save(itemToSave);
        //add children to item

        // Using Stream to map each ChildrenDTO to a Map<String, Object>
        List<Map<String, Object>> children = dto.getChildren().stream()
            .map(child -> {
                Map<String, Object> data = new HashMap<>();
                data.put("id", child.getId()); // Extracting child ID
                data.put("quantity", child.getQuantity()); // Extracting quantity
                return data; // Returning the map
            }).collect(Collectors.toList()); // Collecting into a list

        this.addChildrenToItem(savedItem, children);
        //==============================
        List<ChildrenItem> childrenItemList = childrenItemRepo.findByParentId(savedItem.getId());
        savedItem = itemRepo.findById(savedItem.getId()).orElse(null);

        return savedItem == null ? null : new ItemResponseDTO(savedItem, childrenItemList);
    }



    @Override
    public ItemResponseDTO findById(Long id) {
        ItemResponseDTO result = null;
        Item item = itemRepo.findById(id).orElse(null);

        if (item != null) {
            List<ChildrenItem> childrenItemList = childrenItemRepo.findByParentId(item.getId());
            result = new ItemResponseDTO(item,childrenItemList);
        }
        return result;
    }

    @Override
    public Item findItemById(Long id) {
        return itemRepo.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void addChildrenToItem(Item item, List<Map<String, Object>> childrenList) {

      itemOnChildrenItemRepo.deleteAllByItemId(item.getId());

        List<ItemOnChildrenItem> list = new ArrayList<>();

        childrenList.forEach((child -> {
            Long id = (Long) child.get("id");
            Float quantity = (Float) child.get("quantity");
            ChildrenItem foundItem = childrenItemRepo.findById(id).orElse(null);
            if (foundItem != null) {
                switch (item.getCategory_type()){
                    case COMBO:
                        break;
                    default:
                        quantity = 1.0f;
                        break;
                }
                list.add(new ItemOnChildrenItem(item, foundItem,quantity));
            }
        }));

        itemOnChildrenItemRepo.saveAll(list);
    }


    @Override
    public void  delete(Long id) {
        itemOnChildrenItemRepo.deleteAllByItemId(id);
        itemRepo.deleteById(id);
    }
}
