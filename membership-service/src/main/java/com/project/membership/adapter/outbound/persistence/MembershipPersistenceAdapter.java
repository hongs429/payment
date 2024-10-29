package com.project.membership.adapter.outbound.persistence;


import com.project.common.PersistenceAdapter;
import com.project.membership.application.port.outbound.FindMembershipPort;
import com.project.membership.application.port.outbound.ModifyMembershipPort;
import com.project.membership.application.port.outbound.RegisterMembershipPort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

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

    @Override
    public MembershipEntity findMembership(Long membershipId) {
        return membershipRepository.findByIdOrThrow(membershipId);
    }

    @Override
    public MembershipEntity modifyMembership(Long membershipId, String membershipName, String membershipEmail,
                                       String membershipAddress, Boolean membershipIsValid, Boolean membershipIsCorp) {
        MembershipEntity membershipEntity = membershipRepository.findByIdOrThrow(membershipId);

        membershipEntity.update(membershipName, membershipEmail, membershipAddress, membershipIsValid, membershipIsCorp);

        return membershipRepository.save(membershipEntity);

    }
}
