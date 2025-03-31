package com.contable.contable.domain.repository;

import com.contable.contable.application.dto.FinancialSummaryDTO;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

public interface FinancialSummaryRepository {
    Mono<Double> getTotalEntriesByMonth(Integer month);
    Mono<Double> getTotalExitsByMonth(Integer month);
    Mono<Double> getTotalEntriesByYear(Integer year);
    Mono<Double> getTotalExitsByYear(Integer year);
    Mono<FinancialSummaryDTO>  findById(String id);
    List<FinancialSummaryDTO> findAll();
    Mono<FinancialSummaryDTO> findByMonth(Integer month);
}
