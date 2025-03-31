package com.contable.contable.infrastructure.adapter.out;

import com.contable.contable.application.dto.FinancialSummaryDTO;
import com.contable.contable.domain.model.FinancialSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface JpaFinancialSummaryRepository extends JpaRepository<FinancialSummaryEntity, FinancialSummaryDTO> {

    Mono<FinancialSummaryDTO> findByMonth(Integer month);
    Mono<FinancialSummaryDTO> findByYear(Integer year);
    Mono<FinancialSummaryDTO> findById(String id);
    Mono<FinancialSummaryDTO> deleteById(String id);
    Mono<FinancialSummaryDTO> save(FinancialSummaryDTO financialSummaryDTO);
}
