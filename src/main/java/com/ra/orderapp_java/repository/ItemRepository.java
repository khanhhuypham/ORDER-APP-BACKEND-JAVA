package com.ra.orderapp_java.repository;


import com.ra.orderapp_java.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.List;


public interface ItemRepository extends JpaRepository<Item,Long>{
    @Query("select f from Item f where f.name like %:keyword%")
    List<Item> searchByName(String keyword);


    @Query("SELECT i FROM Item i " +
            "WHERE (:categoryId <= 0 OR i.category.id = :categoryId) " +
            "AND (:search_key IS NULL OR i.name LIKE %:search_key%) "
    )
    Page<Item> findAllByCondition(
            @Param("categoryId") Long categoryId,
            @Param("search_key") String search_key,
            Pageable pageable // Use Pageable for pagination
    );


}
