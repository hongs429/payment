package com.project.membership.adapter.inbound.web;


import com.project.membership.application.port.inbound.RegisterMembershipCommand;
import com.project.membership.application.port.inbound.RegisterMembershipUseCase;
import com.project.membership.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/memberships")
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/actions/register")
    public Membership registerMembership(@RequestBody RegisterMembershipRequest registerMembershipRequest) {
        // request -> Command
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(registerMembershipRequest.getName())
                .email(registerMembershipRequest.getEmail())
                .address(registerMembershipRequest.getAddress())
                .isValid(true)
                .isCorp(registerMembershipRequest.getIsCorp())
                .build();

        // Use-case
        return registerMembershipUseCase.registerMembership(command);
    }
}