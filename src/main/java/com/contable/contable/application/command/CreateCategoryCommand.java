package com.contable.contable.application.command;

import com.contable.contable.application.dto.AccountingCategoryDTO;
import com.contable.contable.application.dto.ResponseDTO;
import com.contable.contable.application.usecase.CreateCategoryCommandUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/contable/api/categories", produces = "application/json", consumes = "application/json")
public class CreateCategoryCommand {

    private final CreateCategoryCommandUseCase createCategoryCommandUseCase;

    @PostMapping("/create")
    public Mono<ResponseDTO> createCategory(List<AccountingCategoryDTO> accountingCategoryDTOList) {
        return createCategoryCommandUseCase.createCategory(accountingCategoryDTOList);
    }
}
