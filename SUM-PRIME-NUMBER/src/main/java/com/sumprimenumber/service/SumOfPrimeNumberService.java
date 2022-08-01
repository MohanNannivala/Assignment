package com.sumprimenumber.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SumOfPrimeNumberService {

    public long calculateSumOfPrimeNumbers(long number){

        long result=0;

        ArrayList<Boolean> isPrime=new ArrayList<>();

        for(int i=0; i<=number; i++){
            isPrime.add(true);
        }

        for(int i=2; i<=Math.sqrt(number); i++){
            if(isPrime.get(i)){
                for(int j=i*i; j<=number; j+=i){
                    isPrime.set(j, false);
                }
            }
        }

        for(int i=2; i<=number; i++){
            if(isPrime.get(i)){
                result+=i;
            }
        }

        return result;
    }

}
