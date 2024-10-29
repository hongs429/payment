package com.project.membership.application.port.inbound;


import com.project.common.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
public class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {
    @NotNull
    private final Long membershipId;

    @NotNull
    private final String name;

    @NotNull
    private final String address;

    @NotNull
    private final String email;

    @NotNull
    private final Boolean isValid;

    @NotNull
    private final Boolean isCorp;

    public ModifyMembershipCommand(Long id, String name, String address, String email, Boolean isValid, Boolean isCorp) {
        this.membershipId = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;

        this.validateSelf();
    }
}
