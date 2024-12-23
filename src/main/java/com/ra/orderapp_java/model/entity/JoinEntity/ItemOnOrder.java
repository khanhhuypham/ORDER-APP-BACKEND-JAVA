package com.ra.orderapp_java.model.entity.JoinEntity;

import com.ra.orderapp_java.model.constant.ITEM_ON_ORDER_STATUS;
import com.ra.orderapp_java.model.dto.ItemOnOrder.ItemOnOrderRequestDTO;
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
class ItemOnOrderKey implements Serializable {
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
@Table(name = "item_on_order")
public class ItemOnOrder {
    @EmbeddedId
    ItemOnOrderKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    Item item;

    @Column(name = "allow_return")
    private Boolean allow_return;

    @Column(name = "quantity")
    private Float quantity;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "net_amount")
    private Double net_amount;

    @Column(name = "discount")
    private Integer discount;

    @Column(name="status",columnDefinition = "integer default 0")
    @Enumerated(EnumType.ORDINAL)
    private ITEM_ON_ORDER_STATUS status;

    @Column(name = "note")
    private String note;

    public ItemOnOrder(Order order, Item item) {
        // Create ItemOnChildrenItemKey
        ItemOnOrderKey id = new ItemOnOrderKey();
        id.setItemId(item.getId());
        id.setOrderId(order.getId());
        this.id = id;
        this.order = order;
        this.item = item;
        this.quantity = 1.0f;
        this.amount =  9.5;
        this.net_amount = 9.5;
    }

    public ItemOnOrder(Order order,Item item, ItemOnOrderRequestDTO dto) {
        // Create ItemOnChildrenItemKey
        ItemOnOrderKey id = new ItemOnOrderKey();
        id.setItemId(item.getId());
        id.setOrderId(order.getId());
        this.id = id;
        this.order = order;
        this.item = item;
        this.quantity = dto.getQuantity();
//        this.amount =  dto.get
        this.note = dto.getNote();
        this.net_amount = 9.5;

    }
}