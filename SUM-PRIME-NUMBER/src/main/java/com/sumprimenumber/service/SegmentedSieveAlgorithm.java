package com.sumprimenumber.service;

import java.util.ArrayList;

public class SegmentedSieveAlgorithm{

    public long createSieveArray(int segmentStart, int segmentEnd, ArrayList<Integer> primeNumbers){

        ArrayList<Boolean> segmentedSieveArray=new ArrayList<>();
        long sum=0L;

        /**
         * To identify the primes in current range [segmentStart..segmentEnd],
         * ith index will be false if it is not a prime number else true
         */
        for(int i=segmentStart; i<=segmentEnd; i++){
            segmentedSieveArray.add(true);
        }

        // Using the prime numbers found from sieve algorithm to find primes in current range [segmentStart..segmentEnd]
        for(int primeNumber : primeNumbers ){

            /**
             *  Find the minimum number in [segmentStart..segmentEnd] that is a multiple of primeNumber
             *  For example, if low is 21 and primeNumber is 2 we start with 22
            **/

            int firstMultiple = segmentStart/primeNumber * primeNumber;

            if(firstMultiple < segmentStart){
                firstMultiple+=primeNumber;
            }

            //Mark all composite numbers (multiple of primeNumber) as false.
            for(int i=firstMultiple; i<=segmentEnd; i+=primeNumber){
                segmentedSieveArray.set(i-segmentStart, false);
            }
        }

        //Add all the prime numbers in the current range [segmentStart..segmentEnd]
        for(int i=0; i<segmentedSieveArray.size(); i++){
            if(segmentedSieveArray.get(i)){
                sum+=(i+segmentStart);
            }
        }

        return sum;

    }

}
