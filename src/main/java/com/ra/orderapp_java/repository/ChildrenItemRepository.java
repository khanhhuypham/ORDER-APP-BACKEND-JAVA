package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.ChildrenItem;
import com.ra.orderapp_java.model.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChildrenItemRepository extends JpaRepository<ChildrenItem,Long> {
    @Query("SELECT ci FROM ChildrenItem ci WHERE ci.name LIKE :keyword")
    List<ChildrenItem> searchByName(@Param("keyword") String keyword);


    @Query("SELECT childrenTable " +
            "FROM ChildrenItem childrenTable JOIN childrenTable.items joinTable " +
            "WHERE joinTable.item.id = :parentId")
    List<ChildrenItem> findByParentId(@Param("parentId") Long id);
}
