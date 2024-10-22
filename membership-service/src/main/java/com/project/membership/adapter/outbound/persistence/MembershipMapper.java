package com.project.membership.adapter.outbound.persistence;


import com.project.membership.domain.Membership;
import org.springframework.stereotype.Component;


@Component
public class MembershipMapper {

    public Membership toDomainEntity(MembershipEntity membershipEntity) {
        return Membership.generateMembership(membershipEntity.getMembershipId().toString(), membershipEntity.getName(),
                membershipEntity.getEmail(), membershipEntity.getAddress(), membershipEntity.getIsValid(),
                membershipEntity.getIsCorp());
    }
}
