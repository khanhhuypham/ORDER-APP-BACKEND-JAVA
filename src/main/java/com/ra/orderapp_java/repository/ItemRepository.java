package com.ra.orderapp_java.repository;


import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.List;


public interface ItemRepository extends JpaRepository<Item,Long>{



    @Query(
        "SELECT i FROM Item i " +
        "WHERE (:category_type IS NULL OR i.category_type IN :category_type ) " +
        "AND (:category_id IS NULL OR i.category.id = :category_id) " +
        "AND (:out_of_stock IS NULL OR i.out_of_stock = :out_of_stock) " +
        "AND (:search_key IS NULL OR i.name LIKE %:search_key%) "
    )
    Page<Item> findAllByCondition(
            @Param("category_type") List<CATEGORY_TYPE> category_type,
            @Param("category_id") Long categoryId,
            @Param("out_of_stock") Boolean out_of_stock,
            @Param("search_key") String search_key,
            Pageable pageable // Use Pageable for pagination
    );


}
