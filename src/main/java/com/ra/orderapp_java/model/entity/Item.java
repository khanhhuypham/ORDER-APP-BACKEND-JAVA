package com.ra.orderapp_java.model.entity;

import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnChildrenItem;
import com.ra.orderapp_java.model.entity.JoinEntity.OrderOnItem;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "`item`")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 100)
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private Double price;


    @Column(name = "out_of_stock")
    private boolean out_of_stock;

    @Column(name = "sell_by_weight")
    private boolean sell_by_weight;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "unit_id",referencedColumnName = "id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "printer_id",referencedColumnName = "id")
    private Printer printer;

    @OneToMany(mappedBy = "item")
    Set<ItemOnChildrenItem> children;

    @OneToMany(mappedBy = "item")
    Set<OrderOnItem> orders;

}
