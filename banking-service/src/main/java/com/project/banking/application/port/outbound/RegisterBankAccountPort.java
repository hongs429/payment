package com.project.banking.application.port.outbound;

import com.project.banking.adapter.outbound.persistence.BankAccountJpaEntity;

public interface RegisterBankAccountPort {

    BankAccountJpaEntity createBankAccount(
            Long membershipId,
            String bankName,
            String bankAccountNumber,
            Boolean linkedStatusIsValid
    );
}
