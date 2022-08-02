package com.sumprimenumber.service;

import java.util.ArrayList;

public class SieveAlgorithm {

    public void createSieveArray(long number, ArrayList<Integer> primeNumbers){

        ArrayList<Boolean> isPrime=new ArrayList<>();

        for(int i = 0; i<=number; i++){
            isPrime.add(true);
        }

        for(int i=2; i*i<=number; i++){
            if(isPrime.get(i)){
                for(int j=i*i; j<=number; j+=i){
                    isPrime.set(j, false);
                }
            }
        }

        for(int i=2; i<isPrime.size(); i++){
            if(isPrime.get(i)){
                primeNumbers.add(i);
            }
        }

    }
}
