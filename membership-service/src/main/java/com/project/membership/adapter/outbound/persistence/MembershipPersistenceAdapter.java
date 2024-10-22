package com.project.membership.adapter.outbound.persistence;


import com.project.membership.application.port.outbound.RegisterMembershipPort;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipEntity createMembership(String membershipName, String membershipEmail, String membershipAddress,
                                 Boolean membershipIsValid, Boolean membershipIsCorp) {

        return membershipRepository.save(MembershipEntity.of(membershipName,
                membershipAddress,
                membershipEmail,
                membershipIsValid,
                membershipIsCorp));
    }
}
