package com.afourtech.producer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestHttpRequestForProducer {

    @LocalServerPort
    private int port;

    @Autowired
    MaxOfNumbersController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("[HTTP Request] Test, the API call returns the maximum number.")
    void sanityTest(){
        ProducerResponse res = restTemplate.postForObject("http://localhost:"+port+"/max-number", new ProducerRequest(999,882,989), ProducerResponse.class);
        assertThat(res.getMax_Number()).isEqualTo(999);
    }
}
