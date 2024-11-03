package com.project.banking.application.port.outbound;

import com.project.banking.adapter.outbound.bank.ExternalBankAccount;
import com.project.banking.adapter.outbound.bank.GetBankAccountRequest;

public interface RequestBankAccountInfoPort {

    ExternalBankAccount getBankAccountInfo(GetBankAccountRequest request);
}
