package com.contable.contable.domain.repository;

import com.contable.contable.application.dto.AccountingCategoryDTO;

import java.util.List;
import java.util.Optional;

public interface AccountingCategoryRepository {

     List<AccountingCategoryDTO> findAll();
    Optional<AccountingCategoryDTO> findByName(String name);
    Optional<AccountingCategoryDTO> save(AccountingCategoryDTO accountingCategoryDTO);

}
