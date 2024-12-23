package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.entity.Category;
import com.ra.orderapp_java.model.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query(
        "SELECT c FROM Category c " +
        "WHERE (:active IS NULL OR c.active = :active) " +
        "AND (:type IS NULL OR c.type = :type)"
    )
    List<Category> findAllByCondition(
            @Param("active") Boolean active,
            @Param("type") CATEGORY_TYPE type
    );
}