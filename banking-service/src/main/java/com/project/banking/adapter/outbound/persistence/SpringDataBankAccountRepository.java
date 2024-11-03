package com.project.banking.adapter.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBankAccountRepository extends JpaRepository<BankAccountJpaEntity, Long> {
}
