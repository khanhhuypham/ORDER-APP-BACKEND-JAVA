package com.ra.orderapp_java.repository.joinEntity;

import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemOnOrderRepository extends JpaRepository<ItemOnOrder,Long> {
    @Query(value = "select * from ItemOnOrder where ItemOnOrder.id.itemId =:id ",nativeQuery = true)
    ItemOnOrder findByItemId(@Param("id") Long id);
}
