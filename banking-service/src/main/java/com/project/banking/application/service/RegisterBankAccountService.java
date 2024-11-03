package com.project.banking.application.service;

import com.project.banking.adapter.outbound.bank.ExternalBankAccount;
import com.project.banking.adapter.outbound.bank.GetBankAccountRequest;
import com.project.banking.adapter.outbound.persistence.BankAccountJpaEntity;
import com.project.banking.adapter.outbound.persistence.BankAccountMapper;
import com.project.banking.application.port.inbount.RegisterBankAccountCommand;
import com.project.banking.application.port.inbount.RegisterBankAccountUseCase;
import com.project.banking.application.port.outbound.RegisterBankAccountPort;
import com.project.banking.application.port.outbound.RequestBankAccountInfoPort;
import com.project.banking.domain.BankAccount;
import com.project.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RequestBankAccountInfoPort requestBankAccountInfoPort;
    private final BankAccountMapper bankAccountMapper;


    /**
     * @은행 계좌를 등록해야하는 서비스
     * @맴버 서비스도 확인? 일단은 스킵<br>
     *      1. 등록된 은행 계좌인지 확인<br>
     *          - 외부의 은행에 이 계좌 정상인지, 이미 등록된건 아닌지 확인<br>
     *          - 외부로의 통신이 필요하다.<br> port-> adapter -> external system
     *
     *
     * @2. 등록가능한 계좌라면, 등록 but 에러 리턴
     * @3.
     */
    @Override
    public BankAccount createBankAccount(RegisterBankAccountCommand command) {

        // 실제 맴버쉽은 유효한지 확인해야한다
//        command.getMembershipId();

        // 실제 외부의 은행계좌 정보를 Get. 필요 정보 : bankName, bankAccountNumber
        ExternalBankAccount bankAccountInfo = requestBankAccountInfoPort.getBankAccountInfo(
                new GetBankAccountRequest(command.getBankName(),
                        command.getBankAccountNumber()));

        if (!bankAccountInfo.isValidExternalBankAccount()) {
           throw new IllegalArgumentException("Invalid external bank account number");
        }

        BankAccountJpaEntity bankAccount = registerBankAccountPort.createBankAccount(
                command.getMembershipId(),
                command.getBankName(),
                command.getBankAccountNumber(),
                command.getLinkedStatusIsValid()
        );

        return bankAccountMapper.toDomainEntity(bankAccount);
    }
}
