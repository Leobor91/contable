package com.contable.contable.application.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AccountingCategoryDTO {

    private String id;
    private String name;
    private String description;
    private String icon;
    private String color;
    private String type;
}
