package com.ra.orderapp_java.model.entity.JoinEntity;

import com.ra.orderapp_java.model.constant.ITEM_ON_ORDER_STATUS;
import com.ra.orderapp_java.model.dto.ItemOnOrder.ItemOnOrderDTO;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    Item item;

    @Column(name = "allow_return")
    @Builder.Default
    private Boolean allow_return = false;

    @Column(name = "quantity")
    private Float quantity;


    @Column(name = "discount_amount")
    private Double discount_amount;

    @Column(name = "discount_percent")
    private Integer discount_percent;

    @Column(name="status",nullable = false)
    @Enumerated(EnumType.ORDINAL)
    @Builder.Default
    private ITEM_ON_ORDER_STATUS status = ITEM_ON_ORDER_STATUS.WAITING_PROCESS;

    @Column(name = "note")
    private String note;

    public ItemOnOrder(Order order,Item item, ItemOnOrderDTO dto) {
        // Create ItemOnChildrenItemKey
        ItemOnOrderKey id = new ItemOnOrderKey();
        id.setItemId(item.getId());
        id.setOrderId(order.getId());
        this.id = id;
        this.order = order;
        this.item = item;
        this.quantity = dto.getQuantity();
        this.discount_amount = dto.getDiscount_amount();
        this.discount_percent = dto.getDiscount_percent();
        this.note = dto.getNote();

        // Set default status when add new item to order
        this.status = ITEM_ON_ORDER_STATUS.WAITING_PROCESS; // Default value explicitly set here
    }


}