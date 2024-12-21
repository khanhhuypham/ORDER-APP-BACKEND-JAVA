package com.ra.orderapp_java.service.childrenItem;

import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemRequestDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.model.entity.ChildrenItem;
import com.ra.orderapp_java.model.entity.Unit;
import com.ra.orderapp_java.repository.CategoryRepository;
import com.ra.orderapp_java.repository.ChildrenItemRepository;
import com.ra.orderapp_java.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChildrenItemServiceImpl implements ChildrenItemService{
    private final ChildrenItemRepository ChildrenItemRepo;
    private final CategoryRepository categoryRepo;
    private final UnitRepository unitRepo;

    @Override
    public List<ChildrenItemResponseDTO> findAll() {
        List<ChildrenItemResponseDTO> list = new ArrayList<>();

        for (ChildrenItem child: ChildrenItemRepo.findAll()) {
            list.add(new ChildrenItemResponseDTO(child));
        }

        return list;
    }

    @Override
    public ChildrenItemResponseDTO create(Long id,ChildrenItemRequestDTO dto) {


        Unit unit = unitRepo.findById(dto.getUnit_id()).orElse(null);
        Category category = categoryRepo.findById(dto.getCategory_id()).orElse(null);

        ChildrenItem child = ChildrenItemRepo.save(
            ChildrenItem.builder()
                .id(id)
                .name(dto.getName())
                .price(dto.getPrice())
                .out_of_stock(dto.getOut_of_stock())
                .description(dto.getDescription())
                .category(category)
                .unit(unit)
                .build()
        );

        return new ChildrenItemResponseDTO(child);
    }

    @Override
    public ChildrenItemResponseDTO findById(Long id) {
        ChildrenItem child = ChildrenItemRepo.findById(id).orElse(null);
        return child == null ? null : new ChildrenItemResponseDTO(child);
    }

    @Override
    public void delete(long id) {
        ChildrenItemRepo.deleteById(id);
    }
}
