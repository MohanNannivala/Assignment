package com.sumprimenumber.controllers;

import com.sumprimenumber.Exception.InvalidInputException;
import com.sumprimenumber.service.SumOfPrimeNumberService;
import com.sumprimenumber.util.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/primeSum")
public class SumOfPrimeNumberController {
    @Autowired
    SumOfPrimeNumberService sumOfPrimeNumberService;

    @GetMapping("/v1")
    public Long calculateSumOfPrimeNumbers(@RequestParam long limit) {
        return sumOfPrimeNumberService.calculateSumOfPrimeNumbers(limit);
    }
}
