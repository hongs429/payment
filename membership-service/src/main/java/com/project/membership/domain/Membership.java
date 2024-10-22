package com.project.membership.domain;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {
    String membershipId;
    String name;
    String email;
    String address;
    Boolean isValid;
    Boolean isCorp;

    public static Membership generateMembership(String membershipId,
                                     String name,
                                     String email,
                                     String address,
                                     Boolean isValid,
                                     Boolean isCorp ) {
        return new Membership(membershipId, name, email, address, isValid, isCorp);
    }
}

