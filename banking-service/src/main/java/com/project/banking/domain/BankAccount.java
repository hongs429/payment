package com.project.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BankAccount {
    String registeredBankAccountId;
    String membershipId;
    String bankName;
    String bankAccountNumber;
    Boolean linkedStatusIsValid;

    public static BankAccount generateRegisteredBankAccount(
            String registeredBankAccountId,
            String membershipId, String bankName,
            String bankAccountNumber,
            Boolean linkedStatusIsValid) {
        return new BankAccount(
                registeredBankAccountId, membershipId, bankName, bankAccountNumber,
                linkedStatusIsValid);
    }
}
