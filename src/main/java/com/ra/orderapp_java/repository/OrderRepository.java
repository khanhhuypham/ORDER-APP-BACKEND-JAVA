package com.ra.orderapp_java.repository;


import com.ra.orderapp_java.model.constant.ORDER_STATUS;
import com.ra.orderapp_java.model.constant.ORDER_TYPE;
import com.ra.orderapp_java.model.entity.Item;
import com.ra.orderapp_java.model.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query(
        "SELECT o FROM Order o " +
        "JOIN OrderOnTable joinTable1 ON o.id = joinTable1.order.id " +  // Correct JOIN with OrderOnTable
        "JOIN TableEntity t ON t.id = joinTable1.table.id " +  // Correct JOIN with TableEntity (with alias 't')
        "JOIN Payment p ON p.id = o.payment.id " +  // Correct JOIN with Payment (with alias 'p')
        "WHERE (:status IS NULL OR o.status = :status) " +  // Filtering by status
        "AND (:search_key IS NULL OR t.name LIKE %:search_key%) " + // Searching in the 'name' of the associated table
        "AND (:user_id IS NULL OR o.user.id = :user_id) " + // Filtering by user_id
        "AND (:type IS NULL OR o.type = :type)"  // Filtering by ORDER_TYPE
    )
    Page<Order> findAllByCondition(
            @Param("status") ORDER_STATUS status,
            @Param("search_key") String search_key,
            @Param("user_id") Long user_id,
            @Param("type") ORDER_TYPE type,  // Filtering orders by type
            Pageable pageable // Use Pageable for pagination
    );



}
