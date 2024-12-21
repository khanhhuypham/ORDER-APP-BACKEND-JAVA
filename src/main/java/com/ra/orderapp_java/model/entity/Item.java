package com.ra.orderapp_java.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnChildrenItem;
import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnOrder;
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

    @Column(name = "name",length = 100 ,nullable = false,unique = true)
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "price")
    private Double price;

    @Column(name = "out_of_stock", columnDefinition = "boolean default false")
    private Boolean out_of_stock;

    @Column(name = "sell_by_weight", columnDefinition = "boolean default false")
    private Boolean sell_by_weight;

    @Column(name = "description",nullable = true)
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
    @JsonIgnore
    Set<ItemOnChildrenItem> children;

    @OneToMany(mappedBy = "item")
    Set<ItemOnOrder> orders;

}
