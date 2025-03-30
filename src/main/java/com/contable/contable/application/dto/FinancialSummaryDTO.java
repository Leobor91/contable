package com.contable.contable.application.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FinancialSummaryDTO {

    private String id;
    private int month;
    private Double totalEntries;
    private Double totalExits;
    private String lastModified;
    private int year;
}
