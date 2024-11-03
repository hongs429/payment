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
    public MembershipJpaEntity createMembership(String membershipName, String membershipEmail, String membershipAddress,
                                                Boolean membershipIsValid, Boolean membershipIsCorp) {

        return membershipRepository.save(MembershipJpaEntity.of(membershipName,
                membershipAddress,
                membershipEmail,
                membershipIsValid,
                membershipIsCorp));
    }

    @Override
    public MembershipJpaEntity findMembership(Long membershipId) {
        return membershipRepository.findByIdOrThrow(membershipId);
    }

    @Override
    public MembershipJpaEntity modifyMembership(Long membershipId, String membershipName, String membershipEmail,
                                                String membershipAddress, Boolean membershipIsValid, Boolean membershipIsCorp) {
        MembershipJpaEntity membershipJpaEntity = membershipRepository.findByIdOrThrow(membershipId);

        membershipJpaEntity.update(membershipName, membershipEmail, membershipAddress, membershipIsValid, membershipIsCorp);

        return membershipRepository.save(membershipJpaEntity);

    }
}
