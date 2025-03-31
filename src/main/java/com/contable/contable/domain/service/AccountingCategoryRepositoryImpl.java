package com.contable.contable.domain.service;

import com.contable.contable.application.dto.AccountingCategoryDTO;
import com.contable.contable.domain.model.AccountingCategoryEntity;
import com.contable.contable.domain.repository.AccountingCategoryRepository;
import com.contable.contable.infrastructure.adapter.out.JpaAccountingCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountingCategoryRepositoryImpl implements AccountingCategoryRepository {

    @Autowired
    private final JpaAccountingCategoryRepository jpaAccountingCategoryRepository;

    @Override
    public List<AccountingCategoryDTO> findAll() {
        return jpaAccountingCategoryRepository.findAll().stream()
                .map(accountingCategoryEntity -> AccountingCategoryDTO.builder()
                        .id(accountingCategoryEntity.getId())
                        .name(accountingCategoryEntity.getName())
                        .description(accountingCategoryEntity.getDescription())
                        .icon(accountingCategoryEntity.getIcon())
                        .color(accountingCategoryEntity.getColor())
                        .type(accountingCategoryEntity.getType())
                        .build())
                .collect(Collectors.toList());
    }
@Override
public Mono<AccountingCategoryDTO> findByName(String name) {
    return jpaAccountingCategoryRepository.findByName(name);

}

    @Override
    public Mono<AccountingCategoryDTO> save(AccountingCategoryDTO accountingCategoryDTO) {
        return jpaAccountingCategoryRepository.save(accountingCategoryDTO);

    }
}
