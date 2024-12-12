package com.ra.orderapp_java.model.entity.JoinEntity;

import com.ra.orderapp_java.model.entity.Item;
import com.ra.orderapp_java.model.entity.Order;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable
class OrderOnItemKey implements Serializable {
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "item_id")
    private Long itemId;

}

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "order_item")
public class OrderOnItem {
    @EmbeddedId
    OrderOnItemKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    Item item;

    @Column(name = "quantity")
    private Float quantity;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "net_amount")
    private Double net_amount;

}