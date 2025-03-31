package com.contable.contable.domain.repository;

import com.contable.contable.application.dto.AccountingCategoryDTO;
import reactor.core.publisher.Mono;

import java.util.List;


public interface AccountingCategoryRepository {

    List<AccountingCategoryDTO> findAll();

    Mono<AccountingCategoryDTO> findByName(String name);

    Mono<AccountingCategoryDTO> save(AccountingCategoryDTO accountingCategoryDTO);

}
