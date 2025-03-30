package com.contable.contable.application.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionDTO {

    private String id;
    private String date;
    private String category;
    private String description;
    private BigDecimal amount;
    private int month;
    private String type;
}
