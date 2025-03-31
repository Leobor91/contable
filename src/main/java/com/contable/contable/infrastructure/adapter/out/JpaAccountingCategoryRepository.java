package com.contable.contable.infrastructure.adapter.out;

import com.contable.contable.application.dto.AccountingCategoryDTO;
import com.contable.contable.domain.model.AccountingCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public interface JpaAccountingCategoryRepository extends JpaRepository<AccountingCategoryEntity, AccountingCategoryDTO> {

    Mono<AccountingCategoryDTO> findByName(String name);

    Mono<AccountingCategoryDTO> save(AccountingCategoryDTO accountingCategoryDTO);


}
