package com.ra.orderapp_java.service.food;


import com.ra.orderapp_java.model.dto.food.FoodRequestDTO;
import com.ra.orderapp_java.model.dto.food.FoodResponseDTO;
import com.ra.orderapp_java.model.entity.Item;
import com.ra.orderapp_java.repository.FoodRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class FoodServiceImp implements FoodService {
    public final FoodRepository foodRepo;

    public FoodServiceImp(FoodRepository foodRepo) {
        this.foodRepo = foodRepo;
    }


    @Override
    public List<FoodResponseDTO> findAll() {

        List<FoodResponseDTO> list = new ArrayList();
        for(Item item : foodRepo.findAll()) {
            list.add(new FoodResponseDTO(item));
        }

        return list;
    }

    @Override
    public Page<FoodResponseDTO> pagination(Pageable pageable,String search_key){
        return foodRepo.findAll(pageable).map(FoodResponseDTO::new);
    }

    @Override
    public List<FoodResponseDTO> searchByFoodName(String keyword) {
        return foodRepo.searchByName(keyword).stream().map(FoodResponseDTO::new).toList();
    }

    @Override
    public FoodResponseDTO create(FoodRequestDTO dto) {
        Item savedItem = foodRepo.save(Item.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .image(dto.getImage())
                .category(dto.getCategory())
                .build());

        return new FoodResponseDTO(savedItem);
    }

    @Override
    public FoodResponseDTO findById(Long id) {
        Item item = foodRepo.findById(id).orElse(null);
        return item == null ? null : new FoodResponseDTO(item);
    }

    @Override
    public void delete(long id) {
        foodRepo.deleteById(id);
    }
}
