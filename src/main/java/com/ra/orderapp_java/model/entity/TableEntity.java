package com.ra.orderapp_java.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.orderapp_java.model.entity.JoinEntity.OrderOnItem;
import com.ra.orderapp_java.model.entity.JoinEntity.OrderOnTable;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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

    @Column(name = "name",length = 100,unique = true)
    private String name;

    @Column(name = "status",nullable = true)
    private Integer status;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "total_slot", nullable = true)
    private Long total_slot;

    @ManyToOne
    @JoinColumn(name="area_id",referencedColumnName = "id")
    @JsonIgnore
    private Area area;


    @OneToMany(mappedBy = "table")
    @JsonIgnore
    Set<OrderOnTable> orders;

}
