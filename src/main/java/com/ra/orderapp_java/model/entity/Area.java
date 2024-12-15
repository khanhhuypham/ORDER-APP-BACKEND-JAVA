package com.ra.orderapp_java.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",length = 10,unique = true)
    private String name;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<TableEntity> tables;


//    @PrePersist
//    public void setDefaultStatus() {
//        if (this.status == null) {
//            this.status = TABLE_STATUS.CLOSE;
//        }
//    }

}
