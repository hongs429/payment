package com.project.banking.application.port.inbount;

import com.project.common.SelfValidating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {
    @NotNull
    private final Long membershipId;

    @NotNull
    private final String bankName;

    @NotNull
    @NotBlank
    private final String bankAccountNumber;

    @NotNull
    private final Boolean linkedStatusIsValid;

    public RegisterBankAccountCommand(Long membershipId, String bankName, String bankAccountNumber,
                                      Boolean linkedStatusIsValid) {
        this.membershipId = membershipId;
        this.bankName = bankName;
        this.bankAccountNumber = bankAccountNumber;
        this.linkedStatusIsValid = linkedStatusIsValid;

        this.validateSelf();
    }
}
