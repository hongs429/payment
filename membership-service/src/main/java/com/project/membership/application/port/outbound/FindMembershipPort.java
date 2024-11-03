package com.project.membership.application.port.outbound;

import com.project.membership.adapter.outbound.persistence.MembershipJpaEntity;

public interface FindMembershipPort {

    MembershipJpaEntity findMembership(Long membershipId);
}
