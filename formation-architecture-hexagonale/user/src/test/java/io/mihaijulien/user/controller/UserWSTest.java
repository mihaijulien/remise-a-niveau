package io.mihaijulien.user.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class UserWSTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateUser() throws Exception {
        String userJsonBody = """
                {
                "firstName": "Julien",
                "lastName": "Mihai"
                }
                """;
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users").contentType(MediaType.APPLICATION_JSON).content(userJsonBody))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void givenEmptyNameShouldFail() throws Exception {
        String userJsonBody = """
                {
                "firstName": "Julien",
                "lastName": ""
                }
                """;
        mockMvc.perform(MockMvcRequestBuilders.post("/api/users").contentType(MediaType.APPLICATION_JSON).content(userJsonBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
