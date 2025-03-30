package com.contable.contable.domain.repository;

import com.contable.contable.application.dto.FinancialSummaryDTO;

import java.util.List;
import java.util.stream.Stream;

public interface FinancialSummaryRepository {
    Double getTotalEntriesByMonth(Integer month);
    Double getTotalExitsByMonth(Integer month);
    Double getTotalEntriesByYear(Integer year);
    Double getTotalExitsByYear(Integer year);
    FinancialSummaryDTO findById(String id);
    List<FinancialSummaryDTO> findAll();
    FinancialSummaryDTO findByMonth(Integer month);
}
