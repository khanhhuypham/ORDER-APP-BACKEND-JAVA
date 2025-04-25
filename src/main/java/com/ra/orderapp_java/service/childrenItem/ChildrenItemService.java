package com.ra.orderapp_java.service.childrenItem;

import com.ra.orderapp_java.advice.CustomException;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemRequestDTO;
import com.ra.orderapp_java.model.dto.childrenItem.ChildrenItemResponseDTO;
import com.ra.orderapp_java.model.entity.ChildrenItem;

import java.util.List;

public interface ChildrenItemService {
    List<ChildrenItem> findAll();
    ChildrenItem create(Long id,ChildrenItemRequestDTO dto) throws CustomException;
    ChildrenItem findById(Long id) throws CustomException;
    List<ChildrenItem> findByParentId(Long id) throws CustomException;
    void delete(long id);
}
