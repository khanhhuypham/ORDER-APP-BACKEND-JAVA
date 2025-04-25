package com.ra.orderapp_java.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import com.ra.orderapp_java.util.LongListConverter;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "`table`")
public class TableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 10,unique = true)
    private String name;


    @Column(name = "active",columnDefinition = "boolean default false")
    private Boolean active;

    @Column(name = "total_slot", nullable = true)
    private Long total_slot;

    @Column(name = "merge_tables",nullable = true)
    @Convert(converter = LongListConverter.class)
    private List<Long> merge_tables;


    @ManyToOne
    @JoinColumn(name="area_id",referencedColumnName = "id")
    @JsonIgnore
    private Area area;

    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL)
    private List<Order> orders;

}

