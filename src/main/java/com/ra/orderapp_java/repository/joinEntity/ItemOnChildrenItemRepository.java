package com.ra.orderapp_java.repository.joinEntity;


import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnChildrenItem;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemOnChildrenItemRepository extends JpaRepository<ItemOnChildrenItem,Long> {
    @Modifying // Crucial for database modification
    @Transactional
    @Query("DELETE FROM ItemOnChildrenItem joinTable WHERE joinTable.item.id = :itemId")
    void deleteAllByItemId(@Param("itemId") Long id);
}


