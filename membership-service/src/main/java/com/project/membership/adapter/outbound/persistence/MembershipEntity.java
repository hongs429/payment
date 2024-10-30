package com.project.membership.adapter.outbound.persistence;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "membership")
@Getter
@AllArgsConstructor
@Builder
@ToString(of = {"membershipId", "name", "address", "email", "isValid", "isCorp"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MembershipEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipId;

    private String name;
    private String address;
    private String email;
    private Boolean isValid;
    private Boolean isCorp;

    public static MembershipEntity of(String name, String address, String email, Boolean isValid, Boolean isCorp) {
        return MembershipEntity.builder()
                .name(name)
                .address(address)
                .email(email)
                .isValid(isValid)
                .isCorp(isCorp)
                .build();
    }

    public void update(String name, String address, String email, Boolean isValid, Boolean isCorp) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.isValid = isValid;
        this.isCorp = isCorp;
    }
}
