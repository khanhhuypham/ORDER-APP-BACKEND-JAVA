package com.ra.orderapp_java.model.entity;


import com.ra.orderapp_java.model.entity.JoinEntity.ItemOnChildrenItem;
import jakarta.persistence.*;
        import lombok.*;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "children_item")
public class ChildrenItem {
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
    private Boolean out_of_stock;

    @Column(name = "description",nullable = true)
    private String description;


    @ManyToOne
    @JoinColumn(name = "unit_id",referencedColumnName = "id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "childrenItem", cascade = CascadeType.ALL)
    List<ItemOnChildrenItem> items;
}
