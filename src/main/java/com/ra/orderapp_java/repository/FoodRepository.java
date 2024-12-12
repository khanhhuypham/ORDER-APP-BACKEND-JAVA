package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FoodRepository extends JpaRepository<Item,Long> {
    @Query("select f from Item f where f.name like %:keyword%")
    List<Item> searchByName(String keyword);
}
