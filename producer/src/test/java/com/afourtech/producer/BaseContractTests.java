package com.afourtech.producer;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseContractTests {

    @BeforeEach
    public void setUp() {
        final ProducerService producerService = mock(ProducerService.class);
        when(producerService.calculateMaxOfNumbers(1, 2, 3)).thenReturn(new ProducerResponse(3));
        when(producerService.calculateMaxOfNumbers(111, 222, 999)).thenReturn(new ProducerResponse(999));
        RestAssuredMockMvc.standaloneSetup(new MaxOfNumbersController(producerService));
    }
}
