package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.TableEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<TableEntity, Long> {

}