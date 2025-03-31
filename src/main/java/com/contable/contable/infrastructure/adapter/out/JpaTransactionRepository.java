package com.contable.contable.infrastructure.adapter.out;

import com.contable.contable.application.dto.TransactionDTO;
import com.contable.contable.domain.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface JpaTransactionRepository extends JpaRepository<TransactionEntity, TransactionDTO> {

    List<TransactionDTO> findByMonth(Integer month);
    Mono<TransactionDTO> findById(String id);
    Mono<TransactionDTO> deleteById(String id);
    Mono<TransactionDTO> save(TransactionDTO costDTO);

}


