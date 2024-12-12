package com.ra.orderapp_java.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.orderapp_java.model.constant.PRINTER_TYPE;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "tax")
    private Double tax;

    @Column(name = "surcharge")
    private Double surcharge;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "net_amount")
    private Double net_amount;

    @Column(name = "method")
    private Integer method;

    @Column(name = "status")
    private Integer status;
}

