package com.ra.orderapp_java.model.entity.JoinEntity;

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

}