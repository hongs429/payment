package com.project.membership.adapter.inbound.web;

import com.project.membership.application.port.inbound.FindMembershipQuery;
import com.project.membership.application.port.inbound.FindMembershipUseCase;
import com.project.membership.domain.Membership;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/memberships")
public class FindMembershipController {

    private final FindMembershipUseCase findMembershipUseCase;


    @GetMapping("/{membershipId}")
    public ResponseEntity<Membership> findMembership(@PathVariable("membershipId") Long membershipId) {

        FindMembershipQuery query = FindMembershipQuery.builder()
                .membershipId(membershipId)
                .build();

        return ResponseEntity.ok(findMembershipUseCase.findMembership(query));
    }
}
