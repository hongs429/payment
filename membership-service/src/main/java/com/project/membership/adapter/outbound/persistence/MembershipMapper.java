package com.project.membership.adapter.outbound.persistence;


import com.project.membership.domain.Membership;
import org.springframework.stereotype.Component;


@Component
public class MembershipMapper {

    public Membership toDomainEntity(MembershipJpaEntity membershipJpaEntity) {
        return Membership.generateMembership(membershipJpaEntity.getMembershipId().toString(), membershipJpaEntity.getName(),
                membershipJpaEntity.getEmail(), membershipJpaEntity.getAddress(), membershipJpaEntity.getIsValid(),
                membershipJpaEntity.getIsCorp());
    }
}
