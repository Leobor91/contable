package com.contable.contable.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TransactionEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "month", nullable = false)
    private int month;

    @Column(name = "type", nullable = false)
    private String type;


}
