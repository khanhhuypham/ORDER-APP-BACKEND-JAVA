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

import java.util.List;

public interface TableRepository extends JpaRepository<TableEntity, Long> {

    @Query(
        "SELECT t FROM TableEntity t " +
        "WHERE (:area_id IS NULL OR t.area.id = :area_id) " +
        "AND (:active IS NULL OR t.active = :active)" +
        "AND t.area.active = true "
    )
    List<TableEntity> findAllByCondition(
        @Param("area_id") Long area_id,
        @Param("active") Boolean active
    );

    @Query(
            "SELECT t FROM TableEntity t " +
            "WHERE (:area_id IS NULL OR t.area.id = :area_id)"
    )
    List<TableEntity> findAllForManagement(@Param("area_id") Long area_id);
}