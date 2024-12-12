package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<Area,Long> {

}