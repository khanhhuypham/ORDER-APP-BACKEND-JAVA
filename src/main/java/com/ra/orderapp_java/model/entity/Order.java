package com.ra.orderapp_java.model.entity;


import com.ra.orderapp_java.model.constant.ORDER_STATUS;
import com.ra.orderapp_java.model.constant.ORDER_TYPE;
import com.ra.orderapp_java.model.entity.JoinEntity.OrderOnItem;
import com.ra.orderapp_java.model.entity.JoinEntity.OrderOnTable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id", nullable=false)
    private User user;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id", unique = true,nullable=false)
    private Payment payment;


    @Column(name="status",columnDefinition = "integer default 0")
    @Enumerated(EnumType.ORDINAL)
    private ORDER_STATUS status;

    @Column(name="type",columnDefinition = "integer default 0")
    @Enumerated(EnumType.ORDINAL)
    private ORDER_TYPE type;

    @Column(name="using_time")
    private String using_time;

    @Column(name="using_slot")
    private String using_slot;

    @OneToMany(mappedBy = "order")
    Set<OrderOnTable> tables;

    @OneToMany(mappedBy = "order")
    Set<OrderOnItem> items;
}

