package com.project.banking.adapter.outbound.bank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBankAccountRequest {
    private String bankName;
    private String bankAccountNumber;
}
