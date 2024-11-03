package com.project.banking.adapter.outbound.persistence;


import com.project.banking.application.port.outbound.RegisterBankAccountPort;
import com.project.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class BankAccountPersistenceAdapter implements RegisterBankAccountPort {

    private final SpringDataBankAccountRepository bankAccountRepository;

    @Override
    public BankAccountJpaEntity createBankAccount(Long membershipId, String bankName, String bankAccountNumber,
                                                  Boolean linkedStatusIsValid) {
        return bankAccountRepository.save(
                BankAccountJpaEntity.of(
                        membershipId,
                        bankName,
                        bankAccountNumber,
                        linkedStatusIsValid
                )
        );
    }
}
