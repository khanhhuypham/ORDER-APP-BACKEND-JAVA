package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area,Long> {
    @Query("select a from Area a where a.active = :active")
    List<Area> findActiveArea(@Param("active") Boolean active);
}