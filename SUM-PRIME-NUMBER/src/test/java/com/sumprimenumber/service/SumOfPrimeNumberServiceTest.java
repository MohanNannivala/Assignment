package com.sumprimenumber.service;

import com.sumprimenumber.Exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SumOfPrimeNumberServiceTest {

    @Test
    @DisplayName("Testing for valid cases")
    public void testValid(){

        SumOfPrimeNumberService sumOfPrimeNumberService=new SumOfPrimeNumberService();

        assertAll(
                ()->assertEquals(2L, sumOfPrimeNumberService.calculateSumOfPrimeNumbers(2)),
                ()->assertEquals(17L, sumOfPrimeNumberService.calculateSumOfPrimeNumbers(10)),
                ()->assertEquals(12272577818052L, sumOfPrimeNumberService.calculateSumOfPrimeNumbers(20_000_000)),
                ()->assertEquals(279209790387276L, sumOfPrimeNumberService.calculateSumOfPrimeNumbers(100_000_000))
        );

    }

    @Test
    @DisplayName("Testing for Invalid cases")
    public void testInValid(){

        SumOfPrimeNumberService sumOfPrimeNumberService=new SumOfPrimeNumberService();

        assertAll(
                ()->assertThrows(InvalidInputException.class, () -> sumOfPrimeNumberService.calculateSumOfPrimeNumbers(-100)),
                ()->assertThrows(InvalidInputException.class, () -> sumOfPrimeNumberService.calculateSumOfPrimeNumbers(0)),
                ()->assertThrows(InvalidInputException.class, () -> sumOfPrimeNumberService.calculateSumOfPrimeNumbers(1)),
                ()->assertThrows(InvalidInputException.class, () -> sumOfPrimeNumberService.calculateSumOfPrimeNumbers(100_000_001)),
                ()->assertThrows(InvalidInputException.class, () -> sumOfPrimeNumberService.calculateSumOfPrimeNumbers(200_000_000))
        );
    }

}
