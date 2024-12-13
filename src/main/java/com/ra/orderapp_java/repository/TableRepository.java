package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.Item;
import com.ra.orderapp_java.model.entity.TableEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TableRepository extends JpaRepository<TableEntity, Long> {
    @Query("SELECT t FROM TableEntity t WHERE t.area.id = :id")
    List<TableEntity> findAllByAreaId(Long id);

}