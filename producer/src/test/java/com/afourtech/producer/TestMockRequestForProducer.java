package com.afourtech.producer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestMockRequestForProducer {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("[MOCK Request] Test, the API call returns the maximum Number")
    public void sanityTestUsingMocks() throws  Exception{
        this.mockMvc.perform(
                post("/max-number")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"number1\": 111, \"number2\": 222, \"number3\":999 }"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{ \"max_Number\":999 }"));

    }

    
}
