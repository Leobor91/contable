package com.contable.contable.domain.repository;

import com.contable.contable.application.dto.TransactionDTO;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    List<TransactionDTO> findAll();
    List<TransactionDTO> findByMonth(Integer month);
    Mono<TransactionDTO> findById(String id);
    Mono<TransactionDTO> save(TransactionDTO costDTO);
    Mono<TransactionDTO> deleteById(String id);
}
