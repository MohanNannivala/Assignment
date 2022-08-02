package com.sumprimenumber.service;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
public class SumOfPrimeNumberServiceTest {

    @Test
    public void test(){

        SumOfPrimeNumberService sumOfPrimeNumberService=new SumOfPrimeNumberService();

        long expected=0L;
        long actual=sumOfPrimeNumberService.calculateSumOfPrimeNumbers(-100);
        assertEquals(expected, actual);

        expected=0L;
        actual=sumOfPrimeNumberService.calculateSumOfPrimeNumbers(1);
        assertEquals(expected, actual);

        expected=2L;
        actual=sumOfPrimeNumberService.calculateSumOfPrimeNumbers(2);
        assertEquals(expected, actual);

        expected=17L;
        actual=sumOfPrimeNumberService.calculateSumOfPrimeNumbers(10);
        assertEquals(expected, actual);


        expected=12272577818052L;
        actual=sumOfPrimeNumberService.calculateSumOfPrimeNumbers(20_000_000);
        assertEquals(expected, actual);

        expected=279209790387276L;
        actual=sumOfPrimeNumberService.calculateSumOfPrimeNumbers(100_000_000);
        assertEquals(expected, actual);

    }

}
