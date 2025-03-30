package com.contable.contable.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "financial_summary")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FinancialSummaryEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "total_entries", nullable = false)
    private double totalEntries;

    @Column(name = "total_exits", nullable = false)
    private double totalExits;

    @Column(name = "last_modified", nullable = false)
    private String lastModified;

    @Column(name = "year", nullable = false)
    private int year;
}
