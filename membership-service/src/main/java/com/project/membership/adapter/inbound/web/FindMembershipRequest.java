package com.project.membership.adapter.inbound.web;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindMembershipRequest {

    private Long membershipId;
}
