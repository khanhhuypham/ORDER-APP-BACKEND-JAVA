package com.ra.orderapp_java.repository;


import com.ra.orderapp_java.model.constant.ORDER_STATUS;
import com.ra.orderapp_java.model.constant.ORDER_TYPE;
import com.ra.orderapp_java.model.entity.Item;
import com.ra.orderapp_java.model.entity.Order;
import com.ra.orderapp_java.model.entity.TableEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(
        "SELECT o FROM Order o " +
        "LEFT JOIN TableEntity t ON t.id = o.table.id " +
        "JOIN Payment p ON p.id = o.payment.id " +
        "WHERE (:status IS NULL OR o.status IN :status) " +
        "AND (COALESCE(:search_key, '') = '' OR :search_key IS NULL OR t.name LIKE %:search_key%) " +
        "AND (:user_id IS NULL OR o.user.id = :user_id) " +
        "AND (:type IS NULL OR o.type = :type)"
    )
    Page<Order> findAllByCondition(
            @Param("status") List<ORDER_STATUS> status,
            @Param("search_key") String search_key,
            @Param("user_id") Long user_id,
            @Param("type") ORDER_TYPE type,  // Filtering orders by type
            Pageable pageable // Use Pageable for pagination
    );


    @Query(
        "SELECT o FROM Order o " +
        "WHERE (:id IS NULL OR o.table.id = :id) "
    )
    List<Order> findAllByTableId(@Param("id") Long id);
}
