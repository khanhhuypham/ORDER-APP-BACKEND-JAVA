package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.ChildrenItem;
import com.ra.orderapp_java.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChildrenItemRepository extends JpaRepository<ChildrenItem,Long> {

    @Query(
        "SELECT childrenItem FROM ChildrenItem childrenItem " +
        "JOIN ItemOnChildrenItem itemOnChildrenItem ON itemOnChildrenItem.id.childrenItemId = childrenItem.id " +
        "WHERE itemOnChildrenItem.id.itemId = :parentId"
    )
    List<ChildrenItem> findByParentId(@Param("parentId") Long id);
}
