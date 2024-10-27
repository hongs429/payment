package com.project.membership.adapter.outbound.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMembershipRepository extends JpaRepository<MembershipEntity, Long> {

    default MembershipEntity findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new IllegalArgumentException("not found membership")
        );
    }
}
