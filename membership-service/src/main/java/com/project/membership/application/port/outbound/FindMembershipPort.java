package com.project.membership.application.port.outbound;

import com.project.membership.adapter.outbound.persistence.MembershipEntity;

public interface FindMembershipPort {

    MembershipEntity findMembership(Long membershipId);
}
