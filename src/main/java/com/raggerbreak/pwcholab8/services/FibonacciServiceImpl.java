package com.raggerbreak.pwcholab8.services;

import com.raggerbreak.pwcholab8.FibonacciNumber;
import org.springframework.stereotype.Service;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    @Override
    public FibonacciNumber calculateFibonacciNumber(Integer position) {
        if (position <= 1) {
            return FibonacciNumber.builder()
                    .position(position)
                    .value(position)
                    .build();
        }

        int previousFib = 0, currentFib = 1;
        for (int i = 0; i < position - 1; i++) {
            int newFib = previousFib + currentFib;
            previousFib = currentFib;
            currentFib = newFib;
        }

        return FibonacciNumber.builder()
                .position(position)
                .value(currentFib)
                .build();
    }
}
