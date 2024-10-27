package com.project.membership.application.port.inbound;

import com.project.membership.domain.Membership;

public interface FindMembershipUseCase {

    Membership findMembership(FindMembershipQuery query);
}
