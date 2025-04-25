package com.ra.orderapp_java.repository.joinEntity;

import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemOnOrderRepository extends JpaRepository<ItemOnOrder,Long> {
    @Query(
        "SELECT itemOnOrder FROM ItemOnOrder itemOnOrder " +
        "WHERE itemOnOrder.id.itemId = :itemId " +
        "AND itemOnOrder.id.orderId = :orderId"
    )
    Optional<ItemOnOrder> findByItemId(@Param("itemId") Long itemId, @Param("orderId") Long orderId);


    @Query(
        "SELECT itemOnOrder FROM ItemOnOrder itemOnOrder " +
        "WHERE itemOnOrder.id.orderId = :orderId"
    )
    List<ItemOnOrder> findAllByOrderId(@Param("orderId") Long orderId);

}
