package com.project.banking.adapter.outbound.bank;


import com.project.banking.application.port.outbound.RequestBankAccountInfoPort;
import com.project.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort {

    @Override
    public ExternalBankAccount getBankAccountInfo(GetBankAccountRequest request) {

        //원래대로라면, 여기서 외부 은행과 통신하고 정보를 가져온다

        return new ExternalBankAccount(request.getBankName(), request.getBankAccountNumber(), true);
    }
}
