package com.project.banking.adapter.inbound.web;

import com.project.banking.application.port.inbount.RegisterBankAccountCommand;
import com.project.banking.application.port.inbount.RegisterBankAccountUseCase;
import com.project.banking.domain.BankAccount;
import com.project.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bank-accounts")
public class RegisterBankAccountController {

    private final RegisterBankAccountUseCase registerBankAccountUseCase;

    @PostMapping
    public ResponseEntity<BankAccount> registerBankAccount(
            @RequestBody RegisterBankAccountRequest registerBankAccountRequest) {
        RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
                .membershipId(registerBankAccountRequest.getMembershipId())
                .bankName(registerBankAccountRequest.getBankName())
                .bankAccountNumber(registerBankAccountRequest.getBankAccountNumber())
                .linkedStatusIsValid(registerBankAccountRequest.getLinkedStatusIsValid())
                .build();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerBankAccountUseCase.createBankAccount(command));
    }
}
