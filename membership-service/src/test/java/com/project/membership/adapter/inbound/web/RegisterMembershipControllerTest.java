package com.project.membership.adapter.inbound.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.membership.domain.Membership;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestConstructor(autowireMode = AutowireMode.ALL)
@RequiredArgsConstructor
class RegisterMembershipControllerTest {
    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @Test
    void testRegisterMembership() throws Exception {

        RegisterMembershipRequest registerMembershipRequest =
                new RegisterMembershipRequest("name", "address", "email",
                false);

        Membership membership = Membership.generateMembership("1", "name", "email", "address", true, false);

        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/memberships/actions/register")
                        .content(objectMapper.writeValueAsString(registerMembershipRequest))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        );

        resultActions.andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string(
                        objectMapper.writeValueAsString(membership))
                );
    }
}