package com.project.membership.application.service;


import com.project.common.UseCase;
import com.project.membership.adapter.outbound.persistence.MembershipEntity;
import com.project.membership.adapter.outbound.persistence.MembershipMapper;
import com.project.membership.application.port.inbound.ModifyMembershipCommand;
import com.project.membership.application.port.inbound.ModifyMembershipUseCase;
import com.project.membership.application.port.outbound.ModifyMembershipPort;
import com.project.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@Transactional
@RequiredArgsConstructor
public class ModifyMembershipService implements ModifyMembershipUseCase {

    private final ModifyMembershipPort modifyMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership modifyMembership(ModifyMembershipCommand command) {
        MembershipEntity membershipEntity = modifyMembershipPort.modifyMembership(
                command.getMembershipId(),
                command.getName(),
                command.getEmail(),
                command.getAddress(), command.getIsValid(), command.getIsCorp());

        return membershipMapper.toDomainEntity(membershipEntity);
    }
}
