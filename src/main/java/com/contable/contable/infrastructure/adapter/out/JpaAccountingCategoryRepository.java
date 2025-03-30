package com.contable.contable.infrastructure.adapter.out;

import com.contable.contable.application.dto.AccountingCategoryDTO;
import com.contable.contable.domain.model.AccountingCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaAccountingCategoryRepository extends JpaRepository<AccountingCategoryEntity, AccountingCategoryDTO> {

    Optional<AccountingCategoryDTO> findByName(String name);
    Optional<AccountingCategoryDTO> save(AccountingCategoryDTO acountingCategoryDTO);
}
