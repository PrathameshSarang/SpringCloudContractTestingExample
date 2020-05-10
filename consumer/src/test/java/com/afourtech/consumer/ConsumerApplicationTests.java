package com.afourtech.consumer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids = "com.afourtech:producer:+:stubs:8080", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
class ConsumerApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Grade is 'O' when at least one Major is greater than or equal to  90")
    void validateGradeOCondition() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/calculate-grade")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                " \"pcb_score\" : 1,\n" +
                                " \"pcm_score\" : 2,\n" +
                                " \"pcmit_score\" : 3\n" +
                                " }"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{ \"grade\": \"A\"}"));
    }

    @Test
    @DisplayName("Grade is 'A' when at least  Major is greater than or equal to 70 and less than 90")
    void validateGradeACondition() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/calculate-grade")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                " \"pcb_score\" : 1,\n" +
                                " \"pcm_score\" : 2,\n" +
                                " \"pcmit_score\" : 3\n" +
                                " }"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{ \"grade\": \"B\"}"));
    }

}
