package com.project.banking.adapter.inbound.web;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBankAccountRequest {

    private Long membershipId;
    private String bankName;
    private String bankAccountNumber;
    private Boolean linkedStatusIsValid;
}