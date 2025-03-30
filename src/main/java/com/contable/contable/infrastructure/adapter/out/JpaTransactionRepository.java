package com.contable.contable.infrastructure.adapter.out;

import com.contable.contable.application.dto.TransactionDTO;
import com.contable.contable.domain.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTransactionRepository extends JpaRepository<TransactionEntity, TransactionDTO> {

    Optional<TransactionDTO> findByMonth(Integer month);
    Optional<TransactionDTO> findById(String id);
    Optional<TransactionDTO> deleteById(String id);
    Optional<TransactionDTO> save(TransactionDTO costDTO);

}


