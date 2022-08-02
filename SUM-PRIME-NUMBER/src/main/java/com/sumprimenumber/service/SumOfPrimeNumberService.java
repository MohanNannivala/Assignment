package com.sumprimenumber.service;

import com.sumprimenumber.util.Range;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

@Component
public class SumOfPrimeNumberService{

    public long calculateSumOfPrimeNumbers(long number){

        long result = 0L;
        int limit = (int)Math.min(number, (Range.SEGMENT_LENGTH-1));
        ArrayList<Integer> primeNumbers=new ArrayList<>();

        SieveAlgorithm sieveAlgorithm=new SieveAlgorithm();
        sieveAlgorithm.createSieveArray(limit, primeNumbers);

        for(int i : primeNumbers){
            result+=i;
        }

        int low  = limit;
        int high = 2*limit;

        SegmentedSieveAlgorithm segmentedSieveAlgorithm=new SegmentedSieveAlgorithm();

        while(low<number){

            result += segmentedSieveAlgorithm.createSieveArray((int)low, (int)Math.min(number, high), primeNumbers);
            low  = low + limit;

            high = high + limit;
        }

        return result;
    }

}
