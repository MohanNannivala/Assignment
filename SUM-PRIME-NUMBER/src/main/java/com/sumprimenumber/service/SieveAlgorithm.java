package com.sumprimenumber.service;

import java.util.ArrayList;

public class SieveAlgorithm {

    public void createSieveArray(long number, ArrayList<Integer> primeNumbers){

        ArrayList<Boolean> isPrime=new ArrayList<>();

        /**
         * To identify the primes in from "0" to "number" ,
         * ith index will be false if it is not a prime number else true
         */
        for(int i = 0; i<=number; i++){
            isPrime.add(true);
        }

        for(int i=2; i*i<=number; i++){
            if(isPrime.get(i)){

                //set all multiples of i which are not prime (isPrime[j] = false)

                for(int j=i*i; j<=number; j+=i){
                    isPrime.set(j, false);
                }
            }
        }

        //build primeNumber array which contains only prime numbers.
        for(int i=2; i<isPrime.size(); i++){
            if(isPrime.get(i)){
                primeNumbers.add(i);
            }
        }

    }
}
