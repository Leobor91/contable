package com.contable.contable.application.usecase;

import com.contable.contable.application.dto.AccountingCategoryDTO;
import com.contable.contable.application.dto.ResponseDTO;
import com.contable.contable.domain.enums.ValidationError;
import com.contable.contable.domain.repository.AccountingCategoryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class CreateCategoryCommandUseCase {

    private final AccountingCategoryRepository accountingCategoryRepository;


    public Mono<ResponseDTO> createCategory(List<AccountingCategoryDTO> accountingCategoryDTOList) {
        return Flux.fromIterable(accountingCategoryDTOList)
                .flatMap(accountingCategoryDTO -> {
                    String errorMessage = validateData(accountingCategoryDTO);
                    return errorMessage.equalsIgnoreCase(ValidationError.EMPTY.getMessage())
                            ? Mono.just(accountingCategoryDTO)
                            : Mono.error(new IllegalArgumentException(errorMessage));
                })
                .flatMap(accountingCategoryDTO ->
                    accountingCategoryRepository.findByName(accountingCategoryDTO.getName())
                            .flatMap(existingCategory -> existingCategory != null
                                    ? Mono.error(new IllegalArgumentException(ValidationError.NAME_ALREADY_EXISTS.getMessage()))
                                    : accountingCategoryRepository.save(accountingCategoryDTO))
                )
                .collectList()
                .map(savedCategories -> new ResponseDTO(Collections.singletonList(savedCategories), ValidationError.SUCCESS.getMessage()))
                .onErrorResume(e -> Mono.just(new ResponseDTO(null, e.getMessage())));
    }

    public String validateData(AccountingCategoryDTO accountingCategoryDTO) {
        String errorMessage = accountingCategoryDTO.getName() == null || accountingCategoryDTO.getName().isEmpty() ? ValidationError.NAME_REQUIRED.getMessage() :
                accountingCategoryDTO.getDescription() == null || accountingCategoryDTO.getDescription().isEmpty() ? ValidationError.DESCRIPTION_REQUIRED.getMessage() :
                        accountingCategoryDTO.getIcon() == null || accountingCategoryDTO.getIcon().isEmpty() ? ValidationError.ICON_REQUIRED.getMessage() :
                                accountingCategoryDTO.getColor() == null || accountingCategoryDTO.getColor().isEmpty() ? ValidationError.COLOR_REQUIRED.getMessage() :
                                        accountingCategoryDTO.getType() == null || accountingCategoryDTO.getType().isEmpty() ? ValidationError.TYPE_REQUIRED.getMessage() : ValidationError.EMPTY.getMessage();

        if (!errorMessage.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }

        return errorMessage;
    }
}
