package com.contable.contable.infrastructure.adapter.out;

import com.contable.contable.application.dto.FinancialSummaryDTO;
import com.contable.contable.domain.model.FinancialSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JpaFinancialSummaryRepository extends JpaRepository<FinancialSummaryEntity, FinancialSummaryDTO> {

    Optional<FinancialSummaryDTO> findByMonth(Integer month);
    Optional<FinancialSummaryDTO> findByYear(Integer year);
    Optional<FinancialSummaryDTO> findById(String id);
    Optional<FinancialSummaryDTO> deleteById(String id);
    Optional<FinancialSummaryDTO> save(FinancialSummaryDTO financialSummaryDTO);
}
