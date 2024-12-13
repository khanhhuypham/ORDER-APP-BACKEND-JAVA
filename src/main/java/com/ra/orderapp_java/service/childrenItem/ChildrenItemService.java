package com.ra.orderapp_java.service.childrenItem;

import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemRequestDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;

import java.util.List;

public interface ChildrenItemService {
    List<ChildrenItemResponseDTO> findAll();
    ChildrenItemResponseDTO create(Long id,ChildrenItemRequestDTO dto);
    ChildrenItemResponseDTO findById(Long id);
    void delete(long id);
}
