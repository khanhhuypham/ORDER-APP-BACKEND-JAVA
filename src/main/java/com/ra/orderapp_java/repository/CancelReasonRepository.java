package com.ra.orderapp_java.repository;

import com.ra.orderapp_java.model.entity.Area;
import com.ra.orderapp_java.model.entity.CancelReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CancelReasonRepository extends JpaRepository<CancelReason,Long> {

}