package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.Payment;
import com.ra.orderapp_java.model.entity.Printer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
