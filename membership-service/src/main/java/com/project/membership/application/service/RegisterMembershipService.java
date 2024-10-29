package com.project.membership.application.service;

import com.project.common.UseCase;
import com.project.membership.adapter.outbound.persistence.MembershipEntity;
import com.project.membership.adapter.outbound.persistence.MembershipMapper;
import com.project.membership.application.port.inbound.RegisterMembershipCommand;
import com.project.membership.application.port.inbound.RegisterMembershipUseCase;
import com.project.membership.application.port.outbound.RegisterMembershipPort;
import com.project.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@Transactional
@RequiredArgsConstructor
public class RegisterMembershipService implements RegisterMembershipUseCase {

    private final RegisterMembershipPort registerMembershipPort;
    private final MembershipMapper membershipMapper;

    @Override
    public Membership registerMembership(RegisterMembershipCommand command) {
        // command -> biz logic -> DB


        // DB(external system) <- adapter <- port
        MembershipEntity membership = registerMembershipPort.createMembership(command.getName(), command.getEmail(),
                command.getAddress(), command.getIsValid(), command.getIsCorp());

        return membershipMapper.toDomainEntity(membership);


    }
}
