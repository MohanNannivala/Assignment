package com.sumprimenumber.service;

import com.sumprimenumber.Exception.InvalidInputException;
import com.sumprimenumber.util.Range;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

@Component
public class SumOfPrimeNumberService{

    public long calculateSumOfPrimeNumbers(long number){

        //If the number is not in between 2 and 10 million user will get the below exception
        if (number < Range.LOW_LIMIT || number > Range.HIGH_LIMIT) {
            throw new InvalidInputException("Input number is invalid, please provide input between " + Range.LOW_LIMIT + " and " + Range.HIGH_LIMIT);
        }

        long result = 0L;
        // Compute all primes smaller than or equal to square root of number using sieveAlgorithm
        int limit = (int) (floor(sqrt(number))+1);
        ArrayList<Integer> primeNumbers=new ArrayList<>();
        SieveAlgorithm sieveAlgorithm=new SieveAlgorithm();
        sieveAlgorithm.createSieveArray(limit, primeNumbers);

        for(int i : primeNumbers){
            result+=i;
        }

        // Divide the range in different segments We have chosen segment size as sqrt(n).
        int low  = limit;
        int high = 2*limit;

        SegmentedSieveAlgorithm segmentedSieveAlgorithm=new SegmentedSieveAlgorithm();

        //calculate the sum of all the prime numbers between low and high, segment by segment using segmented sieve algorithm.
        while(low<number){

            result += segmentedSieveAlgorithm.createSieveArray(low, (int)Math.min(number, high), primeNumbers);

            //Update low and high for next segment
            low  = low + limit;
            high = high + limit;
        }

        return result;
    }

}
