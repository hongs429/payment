package com.project.membership.application.port.inbound;

import common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

    @NotNull
    private final String name;

    @NotNull
    private final String address;

    @NotNull
    private final String email;

    @AssertTrue
    private final Boolean isValid;

    @NotNull
    private final Boolean isCorp;

    public RegisterMembershipCommand(String name, String address, String email, Boolean isValid, Boolean isCorp) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;

        this.validateSelf();
    }
}
