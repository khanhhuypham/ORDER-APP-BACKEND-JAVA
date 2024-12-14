package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("select c from Category c where c.active = :status")
    List<Category> findActiveCategory(@Param("status") Integer status);

}