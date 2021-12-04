package com.raggerbreak.pwcholab8.controllers;

import com.raggerbreak.pwcholab8.FibonacciNumber;
import com.raggerbreak.pwcholab8.services.FibonacciService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final FibonacciService fibonacciService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("fibonacciNumber", new FibonacciNumber());
        return "fibonacci";
    }

    @PostMapping("/")
    public String calculateFibonacciNumber(@ModelAttribute FibonacciNumber fibonacciNumber, Model model) {
        model.addAttribute("fibonacciNumber",
                fibonacciService.calculateFibonacciNumber(fibonacciNumber.getPosition()));
        return "fibonacci";
    }

}
