package com.ra.orderapp_java.model.entity.JoinEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import com.ra.orderapp_java.model.entity.ChildrenItem;
import com.ra.orderapp_java.model.entity.Item;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable
class ItemOnChildrenItemKey implements Serializable {
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "children_item_id")
    private Long childrenItemId;

}

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "item_on_childrenItem")
public class ItemOnChildrenItem {

    @EmbeddedId
    ItemOnChildrenItemKey id;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id")
    Item item;

    @ManyToOne
    @MapsId("childrenItemId")
    @JoinColumn(name = "children_item_id")
    ChildrenItem childrenItem;

    @Column(name = "quantity")
    private Float quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "temporary_price")
    private Double temporary_price;

    public ItemOnChildrenItem(Item item,ChildrenItem childrenItem,Float quantity) {
        // Create ItemOnChildrenItemKey
        ItemOnChildrenItemKey id = new ItemOnChildrenItemKey();
        id.setItemId(item.getId());
        id.setChildrenItemId(childrenItem.getId());
        this.id = id;
        this.item = item;
        this.childrenItem = childrenItem;
        this.price = item.getPrice();
        this.quantity = quantity;
        this.temporary_price = 9.5;

    }
}