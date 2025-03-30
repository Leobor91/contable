package com.contable.contable.domain.repository;

import com.contable.contable.application.dto.TransactionDTO;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

    List<TransactionDTO> findAll();
    List<TransactionDTO> findByMonth(Integer month);
    Optional<TransactionDTO> findById(String id);
    Optional<TransactionDTO> save(TransactionDTO costDTO);
    Optional<TransactionDTO> deleteById(String id);
}
