package com.project.banking.adapter.outbound.persistence;


import com.project.banking.domain.BankAccount;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "bank_account")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"bankAccountId", "membershipId", "bankName", "bankAccountNumber", "linkedStatusIsValid"})
public class BankAccountJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankAccountId;
    private Long membershipId;
    private String bankName;
    private String bankAccountNumber;
    private Boolean linkedStatusIsValid;

    public static BankAccountJpaEntity of(Long membershipId, String bankName, String bankAccountNumber,
                                          Boolean linkedStatusIsValid) {
        return BankAccountJpaEntity.builder()
                .membershipId(membershipId)
                .bankName(bankName)
                .bankAccountNumber(bankAccountNumber)
                .linkedStatusIsValid(linkedStatusIsValid)
                .build();
    }
}
