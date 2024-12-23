package com.ra.orderapp_java.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.orderapp_java.model.constant.TABLE_STATUS;
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

    @Column(name = "name",length = 10,unique = true)
    private String name;

    @Column(name = "status",nullable = true,columnDefinition = "integer default 0")
    @Enumerated(EnumType.ORDINAL)
    private TABLE_STATUS status = TABLE_STATUS.CLOSE;

    @Column(name = "active",columnDefinition = "boolean default false")
    private Boolean active;

    @Column(name = "total_slot", nullable = true)
    private Long total_slot;

    @ManyToOne
    @JoinColumn(name="area_id",referencedColumnName = "id")
    @JsonIgnore
    private Area area;


    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL)
    private Set<Order> orders;

}
