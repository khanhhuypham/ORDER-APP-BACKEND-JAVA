package com.ra.orderapp_java.repository;


import com.ra.orderapp_java.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
