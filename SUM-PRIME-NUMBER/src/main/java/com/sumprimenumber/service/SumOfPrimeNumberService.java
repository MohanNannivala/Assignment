package com.sumprimenumber.service;

import org.springframework.stereotype.Component;

@Component
public class SumOfPrimeNumberService {

    public long calculateSumOfPrimeNumbers(long number){

        long result=0;

        for(int i=2; i<=number; i++){

            boolean isPrime=true;

            for(int j=2; j<i; j++){
                if(i%j == 0 ){
                    isPrime=false;
                    break;
                }
            }

            if(isPrime){
                result +=i;
                isPrime=true;
            }
        }

        return result;
    }

}
