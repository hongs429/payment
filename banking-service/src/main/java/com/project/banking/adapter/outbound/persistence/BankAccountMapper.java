package com.project.banking.adapter.outbound.persistence;


import com.project.banking.domain.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

    public BankAccount toDomainEntity(BankAccountJpaEntity jpaEntity) {
        return BankAccount.generateRegisteredBankAccount(
                jpaEntity.getBankAccountId().toString(),
                jpaEntity.getMembershipId().toString(),
                jpaEntity.getBankName(),
                jpaEntity.getBankAccountNumber(),
                jpaEntity.getLinkedStatusIsValid()
        );
    }
}
