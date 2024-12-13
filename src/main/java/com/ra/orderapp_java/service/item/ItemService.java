package com.ra.orderapp_java.service.item;


import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemRequestDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.dto.food.ItemRequestDTO;
import com.ra.orderapp_java.model.dto.food.ItemResponseDTO;
import com.ra.orderapp_java.model.entity.ChildrenItem;
import com.ra.orderapp_java.model.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    List<ItemResponseDTO> findAll();
    Page<ItemResponseDTO> pagination(Pageable pageable, String search_key);
    ItemResponseDTO create(Long id, ItemRequestDTO dto);
    void addChildrenToItem(Item item, List<ChildrenItemResponseDTO> childrenList);
    ItemResponseDTO findById(Long id);
    void delete(long id);
}
