package com.project.membership.adapter.outbound.persistence;

public interface FindMembershipPort {

    MembershipEntity findMembership(Long membershipId);
}
