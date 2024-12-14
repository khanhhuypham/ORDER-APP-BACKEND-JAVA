package com.ra.orderapp_java.service.item;


import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.dto.food.ItemQueryDTO;
import com.ra.orderapp_java.model.dto.food.ItemRequestDTO;
import com.ra.orderapp_java.model.dto.food.ItemResponseDTO;
import com.ra.orderapp_java.model.entity.*;

import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnChildrenItem;
import com.ra.orderapp_java.repository.*;
import com.ra.orderapp_java.repository.joinEntity.ItemOnChildrenItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


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

        Page<Item> result = itemRepo.findAllByCondition(
            dto.getCategory_id() <= 0 ? 0L : dto.getCategory_id(),
            dto.getSearch_key(),
            pageable
        );

        for(Item item : result) {
            // Fetch all ChildrenItems in a single query
            List<ChildrenItem> childrenItemList = childrenItemRepo.findByParentId(item.getId());
            list.add(new ItemResponseDTO(item,childrenItemList));
        }
        return PaginationDTO.input(list,result);
    }


//    @Override
//    public Page<ItemResponseDTO> pagination(Pageable pageable, String search_key){
//        List<ItemResponseDTO> list = new ArrayList();
//
//        for(Item item : itemRepo.findAll(pageable)) {
//            // Fetch all ChildrenItems in a single query
//            List<ChildrenItem> childrenItemList = childrenItemRepo.findByParentId(item.getId());
//            list.add(new ItemResponseDTO(item,childrenItemList));
//        }
//
//        return null;
//    }


    @Override
    public ItemResponseDTO create(Long id, ItemRequestDTO dto) {

        Item savedItem = null;
        Category category = categoryRepo.findById(dto.getCategory_id()).orElse(null);
        Unit unit = unitRepo.findById(dto.getUnit_id()).orElse(null);
        Printer printer = printerRepo.findById(dto.getPrinter_id()).orElse(null);

        if (id != null){
            Item foundItem = itemRepo.findById(id).orElse(null);
            savedItem = itemRepo.save(foundItem.builder()
                .id(foundItem.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .image(dto.getImage())
                .description(dto.getDescription())
                .sell_by_weight(dto.getSell_by_weight())
                .out_of_stock(foundItem.getOut_of_stock())
                .category(category)
                .unit(unit)
                .printer(printer)
                .build());
        }else{
            savedItem = itemRepo.save(Item.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .image(dto.getImage())
                .description(dto.getDescription())
                .sell_by_weight(dto.getSell_by_weight())
                .out_of_stock(false)
                .category(category)
                .unit(unit)
                .printer(printer)
                .build());
        }

        this.addChildrenToItem(savedItem, dto.getChildren());

        List<ChildrenItem> childrenItemList = childrenItemRepo.findByParentId(savedItem.getId());

        return new ItemResponseDTO(savedItem,childrenItemList);
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
    public void addChildrenToItem(Item item, List<ChildrenItemResponseDTO> childrenList) {

      itemOnChildrenItemRepo.deleteAllByItemId(item.getId());

        List<ItemOnChildrenItem> itemOnChildrenItemList = childrenList.stream()
            .map((child) -> child.getId())
            .filter((childId) -> childrenItemRepo.findById(childId).isPresent())
            .map((childId) -> childrenItemRepo.findById(childId).get())
            .map(childrenItem -> new ItemOnChildrenItem(item, childrenItem))
            .toList();

        itemOnChildrenItemList.forEach((child -> {
            System.out.println(child.toString());
        }));

        itemOnChildrenItemRepo.saveAll(itemOnChildrenItemList);
    }


    @Override
    public void delete(long id) {
        itemOnChildrenItemRepo.deleteAllByItemId(id);
        itemRepo.deleteById(id);
    }
}
