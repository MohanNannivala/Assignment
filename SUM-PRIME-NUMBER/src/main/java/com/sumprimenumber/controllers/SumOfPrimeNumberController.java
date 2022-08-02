package com.sumprimenumber.controllers;

import com.sumprimenumber.Exception.InvalidInputException;
import com.sumprimenumber.service.SumOfPrimeNumberService;
import com.sumprimenumber.util.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeSum")
public class SumOfPrimeNumberController {
    @Autowired
    SumOfPrimeNumberService sumOfPrimeNumberService;

    @GetMapping("/{number}")
    public Long calculateSumOfPrimeNumbers(@PathVariable long number) {

        if (number < Range.LOW_LIMIT || number > Range.HIGH_LIMIT) {
            throw new InvalidInputException("Input number is invalid, please provide input between " + Range.LOW_LIMIT + " " + Range.HIGH_LIMIT);
        }

        return sumOfPrimeNumberService.calculateSumOfPrimeNumbers(number);
    }
}
