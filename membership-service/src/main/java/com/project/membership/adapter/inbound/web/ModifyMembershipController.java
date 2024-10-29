package com.project.membership.adapter.inbound.web;


import com.project.common.WebAdapter;
import com.project.membership.application.port.inbound.ModifyMembershipCommand;
import com.project.membership.application.port.inbound.ModifyMembershipUseCase;
import com.project.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/memberships")
public class ModifyMembershipController {

    private final ModifyMembershipUseCase modifyMembershipUseCase;

    @PutMapping("/{membershipId}")
    public ResponseEntity<Membership> modifyMembership(
            @PathVariable("membershipId") Long membershipId,
            @RequestBody ModifyMembershipRequest modifyMembershipRequest
    ) {

        ModifyMembershipCommand command = ModifyMembershipCommand.builder()
                .membershipId(membershipId)
                .name(modifyMembershipRequest.getName())
                .email(modifyMembershipRequest.getEmail())
                .isValid(modifyMembershipRequest.getIsValid())
                .isCorp(modifyMembershipRequest.getIsCorp())
                .address(modifyMembershipRequest.getAddress())
                .build();

        return ResponseEntity.ok(modifyMembershipUseCase.modifyMembership(command));
    }
}
