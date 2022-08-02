package com.sumprimenumber.service;

import com.sumprimenumber.Exception.InvalidInputException;
import com.sumprimenumber.util.Range;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

@Component
public class SumOfPrimeNumberService{

    public long calculateSumOfPrimeNumbers(long limit){

        //If the number is not in between 2 and 10 million user will get the below exception
        if (limit < Range.LOW_LIMIT || limit > Range.HIGH_LIMIT) {
            throw new InvalidInputException("Input number is invalid, please provide input between " + Range.LOW_LIMIT + " and " + Range.HIGH_LIMIT);
        }

        long result = 0L;
        // Compute all primes smaller than or equal to square root of number using sieveAlgorithm
        int range = (int) (floor(sqrt(limit))+1);
        ArrayList<Integer> primeNumbers=new ArrayList<>();
        SieveAlgorithm sieveAlgorithm=new SieveAlgorithm();
        sieveAlgorithm.createSieveArray(range, primeNumbers);

        for(int i : primeNumbers){
            result+=i;
        }

        // Divide the range in different segments We have chosen segment size as sqrt(n).
        int low  = range;
        int high = 2*range;

        SegmentedSieveAlgorithm segmentedSieveAlgorithm=new SegmentedSieveAlgorithm();

        //calculate the sum of all the prime numbers between low and high, segment by segment using segmented sieve algorithm.
        while(low<limit){

            result += segmentedSieveAlgorithm.createSieveArray(low, (int)Math.min(limit, high), primeNumbers);

            //Update low and high for next segment
            low  = low + range;
            high = high + range;
        }

        return result;
    }

}
