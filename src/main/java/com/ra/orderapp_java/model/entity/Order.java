package com.ra.orderapp_java.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.orderapp_java.model.constant.ORDER_STATUS;
import com.ra.orderapp_java.model.constant.ORDER_TYPE;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnOrder;
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


    @Column(name="status")
    @Enumerated(EnumType.ORDINAL)
    @Builder.Default
    private ORDER_STATUS status = ORDER_STATUS.OPEN;

    @Column(name="type")
    @Enumerated(EnumType.ORDINAL)
    @Builder.Default
    private ORDER_TYPE type = ORDER_TYPE.DINE_IN;

    @Column(name="using_time")
    private String using_time;

    @Column(name="using_slot", nullable = true)
    private Integer using_slot;

    @ManyToOne
    @JoinColumn(name="table_id",referencedColumnName = "id",nullable = true)
    @JsonIgnore
    private TableEntity table;

    @OneToMany(mappedBy = "order")
    Set<ItemOnOrder> items;
}

