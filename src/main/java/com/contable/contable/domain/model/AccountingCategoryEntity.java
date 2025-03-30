package com.contable.contable.domain.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "accounting_category")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountingCategoryEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "icon")
    private String icon;

    @Column(name = "color")
    private String color;

}
