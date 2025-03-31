package com.contable.contable.domain.service;

import com.contable.contable.application.dto.TransactionDTO;
import com.contable.contable.domain.repository.TransactionRepository;
import com.contable.contable.infrastructure.adapter.out.JpaTransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

    private final JpaTransactionRepository jpaTransactionRepository;

    @Override
    public List<TransactionDTO> findAll() {
        return jpaTransactionRepository.findAll().stream()
                .map(transactionEntity -> TransactionDTO.builder()
                        .id(transactionEntity.getId())
                        .description(transactionEntity.getDescription())
                        .amount(transactionEntity.getAmount())
                        .date(transactionEntity.getDate())
                        .month(transactionEntity.getMonth())
                        .category(transactionEntity.getCategory())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDTO> findByMonth(Integer month) {
        return jpaTransactionRepository.findByMonth(month).stream()
                .map(transactionDTO -> TransactionDTO.builder()
                        .id(transactionDTO.getId())
                        .description(transactionDTO.getDescription())
                        .amount(transactionDTO.getAmount())
                        .date(transactionDTO.getDate())
                        .month(transactionDTO.getMonth())
                        .category(transactionDTO.getCategory())
                        .build())
                .toList();
    }

    @Override
    public Mono<TransactionDTO> findById(String id) {
        return jpaTransactionRepository.findById(id)
                .map(transactionDTO -> TransactionDTO.builder()
                        .id(transactionDTO.getId())
                        .description(transactionDTO.getDescription())
                        .amount(transactionDTO.getAmount())
                        .date(transactionDTO.getDate())
                        .month(transactionDTO.getMonth())
                        .category(transactionDTO.getCategory())
                        .build());
    }

    @Override
    public Mono<TransactionDTO> save(TransactionDTO transactionDTO) {
        return jpaTransactionRepository.save(transactionDTO);
    }

    @Override
    public Mono<TransactionDTO> deleteById(String id) {
        return jpaTransactionRepository.deleteById(id);
    }
}
