//package com.ra.orderapp_java.model.entity.JoinEntity;
//
//import com.ra.orderapp_java.model.entity.Item;
//import com.ra.orderapp_java.model.entity.Order;
//import com.ra.orderapp_java.model.entity.TableEntity;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.io.Serializable;
//
//
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@Embeddable
//class OrderOnTableKey implements Serializable {
//    @Column(name = "order_id")
//    private Long orderId;
//
//    @Column(name = "table_id")
//    private Long tableId;
//
//}
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@Builder
//@Entity
//@Table(name = "order_table")
//public class OrderOnTable {
//    @EmbeddedId
//    OrderOnTableKey id;
//
//    @ManyToOne
//    @MapsId("orderId")
//    @JoinColumn(name = "order_id")
//    Order order;
//
//    @ManyToOne
//    @MapsId("tableId")
//    @JoinColumn(name = "table_id")
//    TableEntity table;
//
//}