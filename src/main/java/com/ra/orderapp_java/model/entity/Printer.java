package com.ra.orderapp_java.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ra.orderapp_java.model.constant.PRINTER_TYPE;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "printer")
public class Printer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",length = 100,unique = true,nullable = false)
    private String name;

    @Column(name = "printer_name",length = 100,unique = true,nullable = false)
    private String printer_name;

    @Column(name = "ip_address")
    private String ip_address;

    @Column(name = "port")
    private Integer port;

    @Column(name = "connection_type")
    private Integer connection_type;

    @Column(name = "print_number")
    private Integer print_number;

    @Column(name = "is_print_each_paper")
    private Boolean is_print_each_paper;

    @Column(name = "is_active")
    private Boolean is_active;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PRINTER_TYPE type;

    @OneToMany(mappedBy = "printer")
    @JsonIgnore
    private Set<Item> items;
}

