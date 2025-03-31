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
                .map(costEntity -> TransactionDTO.builder()
                        .id(costEntity.getId())
                        .description(costEntity.getDescription())
                        .amount(costEntity.getAmount())
                        .date(costEntity.getDate())
                        .month(costEntity.getMonth())
                        .category(costEntity.getCategory())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<TransactionDTO> findByMonth(Integer month) {
        return jpaTransactionRepository.findByMonth(month).stream()
                .map(costDTO -> TransactionDTO.builder()
                        .id(costDTO.getId())
                        .description(costDTO.getDescription())
                        .amount(costDTO.getAmount())
                        .date(costDTO.getDate())
                        .month(costDTO.getMonth())
                        .category(costDTO.getCategory())
                        .build())
                .toList();
    }

    @Override
    public Mono<TransactionDTO> findById(String id) {
        return jpaTransactionRepository.findById(id)
                .map(costDTO -> TransactionDTO.builder()
                        .id(costDTO.getId())
                        .description(costDTO.getDescription())
                        .amount(costDTO.getAmount())
                        .date(costDTO.getDate())
                        .month(costDTO.getMonth())
                        .category(costDTO.getCategory())
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
