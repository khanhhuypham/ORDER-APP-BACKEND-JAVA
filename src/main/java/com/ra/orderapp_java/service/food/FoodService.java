package com.ra.orderapp_java.service.food;


import com.ra.orderapp_java.model.dto.food.FoodRequestDTO;
import com.ra.orderapp_java.model.dto.food.FoodResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FoodService {
    List<FoodResponseDTO> findAll();
    Page<FoodResponseDTO> pagination(Pageable pageable,String search_key);
    List<FoodResponseDTO> searchByFoodName(String keyword);
    FoodResponseDTO create(FoodRequestDTO dto);
    FoodResponseDTO findById(Long id);
    void delete(long id);
}
