package com.project.banking.adapter.outbound.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExternalBankAccount {
    private String bankName;
    private String bankAccountNumber;
    private Boolean isValid;

    public boolean isValidExternalBankAccount() {
        return isValid;
    }
}
