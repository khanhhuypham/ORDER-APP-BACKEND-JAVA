package com.ra.orderapp_java.service.item;


import com.ra.orderapp_java.model.dto.PaginationDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemRequestDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.dto.item.ItemQueryDTO;
import com.ra.orderapp_java.model.dto.item.ItemRequestDTO;
import com.ra.orderapp_java.model.dto.item.ItemResponseDTO;
import com.ra.orderapp_java.model.entity.Item;
import org.hibernate.mapping.Any;

import java.util.List;
import java.util.Map;

public interface ItemService {
    PaginationDTO<ItemResponseDTO> findAll(ItemQueryDTO dto);
    ItemResponseDTO create(Long id, ItemRequestDTO dto);
    void  addChildrenToItem(Item item, List<Map<String, Object>> childrenList);
    ItemResponseDTO findById(Long id);
    Item findItemById(Long id);
    void  delete(Long id);
}
