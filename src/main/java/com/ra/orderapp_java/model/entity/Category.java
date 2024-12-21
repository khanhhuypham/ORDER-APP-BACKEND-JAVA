package com.ra.orderapp_java.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.orderapp_java.model.constant.CATEGORY_TYPE;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 100, nullable = false,unique = true)
    private String name;

    @Column(name="active")
    private Boolean active;

    @Column(name="type",columnDefinition = "integer default 1")
    @Enumerated(EnumType.ORDINAL)
    private CATEGORY_TYPE type = CATEGORY_TYPE.FOOD;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Item> items;

}

