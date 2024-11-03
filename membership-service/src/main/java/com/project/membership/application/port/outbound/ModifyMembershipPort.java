package com.project.membership.application.port.outbound;

import com.project.membership.adapter.outbound.persistence.MembershipJpaEntity;

public interface ModifyMembershipPort {

    MembershipJpaEntity modifyMembership(Long membershipId, String membershipName, String membershipEmail, String membershipAddress,
                                         Boolean membershipIsValid, Boolean membershipIsCorp);
}
