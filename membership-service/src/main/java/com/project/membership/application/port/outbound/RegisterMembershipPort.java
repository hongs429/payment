package com.project.membership.application.port.outbound;


import com.project.membership.adapter.outbound.persistence.MembershipEntity;

public interface RegisterMembershipPort {

    MembershipEntity createMembership(String membershipName, String membershipEmail, String membershipAddress,
                                      Boolean membershipIsValid, Boolean membershipIsCorp);
}
