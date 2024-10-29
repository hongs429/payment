package com.project.membership.adapter.inbound.web;


import com.project.common.WebAdapter;
import com.project.membership.application.port.inbound.RegisterMembershipCommand;
import com.project.membership.application.port.inbound.RegisterMembershipUseCase;
import com.project.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Membership> registerMembership(@RequestBody RegisterMembershipRequest registerMembershipRequest) {
        // request -> Command
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(registerMembershipRequest.getName())
                .email(registerMembershipRequest.getEmail())
                .address(registerMembershipRequest.getAddress())
                .isValid(true)
                .isCorp(registerMembershipRequest.getIsCorp())
                .build();

        // Use-case
        return ResponseEntity.status(HttpStatus.CREATED).body(registerMembershipUseCase.registerMembership(command));
    }
}
