package com.ra.orderapp_java.service.childrenItem;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemRequestDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.model.entity.ChildrenItem;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnChildrenItem;
import com.ra.orderapp_java.model.entity.Unit;
import com.ra.orderapp_java.repository.CategoryRepository;
import com.ra.orderapp_java.repository.ChildrenItemRepository;
import com.ra.orderapp_java.repository.UnitRepository;
import com.ra.orderapp_java.service.category.CategoryService;
import com.ra.orderapp_java.service.unit.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ChildrenItemServiceImpl implements ChildrenItemService{
    private final ChildrenItemRepository ChildrenItemRepo;
    private final CategoryService categoryService;
    private final UnitService unitService;


    @Override
    public List<ChildrenItem> findAll() {
        return ChildrenItemRepo.findAll();
    }

    @Override
    public ChildrenItem create(Long id,ChildrenItemRequestDTO dto) throws CustomException {

        return ChildrenItemRepo.save(
            ChildrenItem.builder()
                .id(id)
                .name(dto.getName())
                .price(dto.getPrice())
                .out_of_stock(dto.getOut_of_stock())
                .description(dto.getDescription())
                .category(categoryService.findById(dto.getCategory_id()))
                .unit(unitService.findById(dto.getUnit_id()))
                .build()
        );
    }

    @Override
    public ChildrenItem findById(Long id) throws CustomException {
        ChildrenItem child = ChildrenItemRepo.findById(id).orElse(null);
        if (child == null){
            throw new CustomException("Item not found", HttpStatus.NOT_FOUND);
        }

        return child;
    }

    @Override
    public List<ChildrenItem> findByParentId(Long id) throws CustomException {
        return ChildrenItemRepo.findByParentId(id);
    }


    @Override
    public void delete(long id) {
        ChildrenItemRepo.deleteById(id);
    }
}
