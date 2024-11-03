package com.project.membership.application.port.outbound;


import com.project.membership.adapter.outbound.persistence.MembershipJpaEntity;

public interface RegisterMembershipPort {

    MembershipJpaEntity createMembership(String membershipName, String membershipEmail, String membershipAddress,
                                         Boolean membershipIsValid, Boolean membershipIsCorp);
}
