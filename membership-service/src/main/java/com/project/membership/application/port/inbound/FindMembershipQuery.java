package com.project.membership.application.port.inbound;

import com.project.common.SelfValidating;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode(callSuper = false)
public class FindMembershipQuery extends SelfValidating<FindMembershipQuery> {

    private final Long membershipId;
}
