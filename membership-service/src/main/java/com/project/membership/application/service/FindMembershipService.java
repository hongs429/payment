package com.project.membership.application.service;


import com.project.common.UseCase;
import com.project.membership.adapter.outbound.persistence.MembershipEntity;
import com.project.membership.adapter.outbound.persistence.MembershipMapper;
import com.project.membership.application.port.inbound.FindMembershipQuery;
import com.project.membership.application.port.inbound.FindMembershipUseCase;
import com.project.membership.application.port.outbound.FindMembershipPort;
import com.project.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FindMembershipService implements FindMembershipUseCase {

    private final FindMembershipPort findMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership findMembership(FindMembershipQuery query) {

        MembershipEntity membership  = findMembershipPort.findMembership(query.getMembershipId());
        return membershipMapper.toDomainEntity(membership);
    }
}
