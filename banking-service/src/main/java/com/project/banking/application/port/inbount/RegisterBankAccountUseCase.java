package com.project.banking.application.port.inbount;

import com.project.banking.domain.BankAccount;

public interface RegisterBankAccountUseCase {

    BankAccount createBankAccount(RegisterBankAccountCommand command);
}
