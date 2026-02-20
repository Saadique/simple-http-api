package com.java.assesment.simplehttpapi.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTest {

    @Autowired
    private MockMvc mockClient;

    @Test
    public void shouldReturnSuccessWhenValidName() throws Exception {
        mockClient.perform(get("/hello-world").param("name", "alice"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"Hello Alice\"}"));
    }

    @Test
    public void shouldReturnErrorWhenNameStartsWithNtoZ() throws Exception {
        mockClient.perform(get("/hello-world").param("name", "zack"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"error\":\"Invalid Input\"}"));
    }

    @Test
    public void shouldReturnErrorWhenNameStartsWithInvalidCharacters() throws Exception {
        mockClient.perform(get("/hello-world").param("name", "@lice"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"error\":\"Invalid Input\"}"));
    }

    @Test
    public void shouldReturnErrorWhenNameIsMissing() throws Exception {
        mockClient.perform(get("/hello-world"))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"error\":\"Invalid Input\"}"));
    }

    @Test
    public void shouldReturnErrorWhenNameIsEmpty() throws Exception {
        mockClient.perform(get("/hello-world").param("name", ""))
                .andExpect(status().isBadRequest())
                .andExpect(content().json("{\"error\":\"Invalid Input\"}"));
    }

    @Test
    public void shouldTrimNameBeforeGeneratingGreeting() throws Exception {
        mockClient.perform(get("/hello-world").param("name", "   alice"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"Hello Alice\"}"));
    }
}