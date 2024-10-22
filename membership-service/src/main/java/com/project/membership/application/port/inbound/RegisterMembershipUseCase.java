package com.project.membership.application.port.inbound;

import com.project.membership.domain.Membership;

public interface RegisterMembershipUseCase {

    // 외부 -> adapter -> inbound/web -> controller -> command -> use-case
    Membership registerMembership(RegisterMembershipCommand command);
}
