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
//@NamedStoredProcedureQuery(name = "`order`.plus1", procedureName = "GET_ORDER_BY_CONDITION",
//parameters = {
//    @StoredProcedureParameter(mode = ParameterMode.IN, name = "search_key", type = String.class),
//    @StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type = Order.class)
//})
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

    @Column(name="using_slot", nullable = true)
    private Integer using_slot;


    @ManyToOne
    @JoinColumn(name="table_id",referencedColumnName = "id",nullable = true)
    @JsonIgnore
    private TableEntity table;

    @OneToMany(mappedBy = "order")
    Set<ItemOnOrder> items;
}

