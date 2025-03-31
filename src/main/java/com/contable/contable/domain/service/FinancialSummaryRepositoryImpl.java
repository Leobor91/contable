package com.contable.contable.domain.service;

import com.contable.contable.application.dto.FinancialSummaryDTO;
import com.contable.contable.domain.repository.FinancialSummaryRepository;
import com.contable.contable.infrastructure.adapter.out.JpaFinancialSummaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class FinancialSummaryRepositoryImpl implements FinancialSummaryRepository {

    private final JpaFinancialSummaryRepository jpaFinancialSummaryRepository;

    @Override
    public Mono<Double> getTotalEntriesByMonth(Integer month) {
        return jpaFinancialSummaryRepository.findByMonth(month)
                .switchIfEmpty(Mono.error(new RuntimeException("No financial summary found for month: " + month)))
                .map(FinancialSummaryDTO::getTotalEntries);
    }

    @Override
    public Mono<Double> getTotalExitsByMonth(Integer month) {
        return jpaFinancialSummaryRepository.findByMonth(month)
                .switchIfEmpty(Mono.error(new RuntimeException("No financial summary found for month: " + month)))
                .map(FinancialSummaryDTO::getTotalExits);
    }

    @Override
    public Mono<Double> getTotalEntriesByYear(Integer year) {
        return jpaFinancialSummaryRepository.findByYear(year)
                .switchIfEmpty(Mono.error(new RuntimeException("No financial summary found for year: " + year)))
                .map(FinancialSummaryDTO::getTotalEntries);
    }

    public Mono<Double> getTotalExitsByYear(Integer year) {
        return jpaFinancialSummaryRepository.findByYear(year)
                .switchIfEmpty(Mono.error(new RuntimeException("No financial summary found for year: " + year)))
                .map(FinancialSummaryDTO::getTotalExits);
    }

    @Override
    public Mono<FinancialSummaryDTO> findById(String id) {
        return jpaFinancialSummaryRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("No financial summary found for id: " + id)));
    }


    @Override
    public List<FinancialSummaryDTO> findAll() {
        return jpaFinancialSummaryRepository.findAll().stream()
                .map(financialSummaryEntity -> FinancialSummaryDTO.builder()
                        .id(financialSummaryEntity.getId())
                        .totalEntries(financialSummaryEntity.getTotalEntries())
                        .totalExits(financialSummaryEntity.getTotalExits())
                        .month(financialSummaryEntity.getMonth())
                        .year(financialSummaryEntity.getYear())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Mono<FinancialSummaryDTO> findByMonth(Integer month) {
        return jpaFinancialSummaryRepository.findByMonth(month)
                .switchIfEmpty(Mono.error(new RuntimeException("No financial summary found for month: " + month)));
    }


}
