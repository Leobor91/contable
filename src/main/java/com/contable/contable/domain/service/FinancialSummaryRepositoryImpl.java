package com.contable.contable.domain.service;

import com.contable.contable.application.dto.FinancialSummaryDTO;
import com.contable.contable.application.dto.TransactionDTO;
import com.contable.contable.domain.model.FinancialSummaryEntity;
import com.contable.contable.domain.repository.FinancialSummaryRepository;
import com.contable.contable.infrastructure.adapter.out.JpaFinancialSummaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class FinancialSummaryRepositoryImpl implements FinancialSummaryRepository {

    private final JpaFinancialSummaryRepository jpaFinancialSummaryRepository;

    @Override
    public Double getTotalEntriesByMonth(Integer month) {
        FinancialSummaryDTO financialSummaryDTO = jpaFinancialSummaryRepository.findByMonth(month)
                .orElseThrow(() -> new RuntimeException("No financial summary found for month: " + month));
        return financialSummaryDTO.getTotalEntries();
    }

    @Override
    public Double getTotalExitsByMonth(Integer month) {
        FinancialSummaryDTO financialSummaryDTO = jpaFinancialSummaryRepository.findByMonth(month)
                .orElseThrow(() -> new RuntimeException("No financial summary found for month: " + month));
        return financialSummaryDTO.getTotalExits();
    }

    @Override
    public Double getTotalEntriesByYear(Integer year) {
        FinancialSummaryDTO financialSummaryDTO = jpaFinancialSummaryRepository.findByYear(year)
                .orElseThrow(() -> new RuntimeException("No financial summary found for year: " + year));
        return financialSummaryDTO.getTotalEntries();
    }

    @Override
    public Double getTotalExitsByYear(Integer year) {
        FinancialSummaryDTO financialSummaryDTO = jpaFinancialSummaryRepository.findByYear(year)
                .orElseThrow(() -> new RuntimeException("No financial summary found for year: " + year));
        return financialSummaryDTO.getTotalExits();
    }

    @Override
    public FinancialSummaryDTO findById(String id) {
        return jpaFinancialSummaryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No financial summary found for id: " + id));
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
    public FinancialSummaryDTO findByMonth(Integer month) {
        return  jpaFinancialSummaryRepository.findByMonth(month)
                .orElseThrow(() -> new RuntimeException("No financial summary found for id: " + month));
    }


}
