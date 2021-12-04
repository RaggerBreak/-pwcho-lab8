package com.raggerbreak.pwcholab8.controllers;

import com.raggerbreak.pwcholab8.FibonacciNumber;
import com.raggerbreak.pwcholab8.services.FibonacciService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class MainControllerTest {

    @Mock
    FibonacciService fibonacciService;

    @InjectMocks
    MainController mainController;

    MockMvc mockMvc;
    FibonacciNumber fibonacciNumber;

    @BeforeEach
    void beforeAll() {
        fibonacciNumber = FibonacciNumber.builder()
                .position(8)
                .value(21)
                .build();

        mockMvc = MockMvcBuilders.standaloneSetup(mainController).build();
    }

    @Test
    void calculateFibonacciNumber() throws Exception {
        when(fibonacciService.calculateFibonacciNumber(any())).thenReturn(fibonacciNumber);

        mockMvc.perform(post("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("fibonacci"))
                .andExpect(model().attributeExists("fibonacciNumber"));

        verify(fibonacciService).calculateFibonacciNumber(any());
    }
}