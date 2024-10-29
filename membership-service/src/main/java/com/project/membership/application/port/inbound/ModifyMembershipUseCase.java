package com.project.membership.application.port.inbound;

import com.project.membership.domain.Membership;

public interface ModifyMembershipUseCase {

    Membership modifyMembership(ModifyMembershipCommand command);
}
