package com.raggerbreak.pwcholab8.services;

import com.raggerbreak.pwcholab8.FibonacciNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciServiceImplTest {

    FibonacciService fibonacciService;

    @BeforeEach
    void setUp() {
        fibonacciService = new FibonacciServiceImpl();
    }

    @Test
    void calculateFibonacciNumber() {
        //given
        Integer position = 8;
        Integer value = 21;

        //when
        FibonacciNumber result = fibonacciService.calculateFibonacciNumber(position);

        //then
        assertEquals(result.getValue(), value);
    }
}