package com.sumprimenumber.service;

import java.util.ArrayList;

public class SegmentedSieveAlgorithm{

    public long createSieveArray(int segmentStart, int segmentEnd, ArrayList<Integer> primeNumbers){

        ArrayList<Boolean> segmentedSieveArray=new ArrayList<>();
        long sum=0L;

        for(int i=segmentStart; i<=segmentEnd; i++){
            segmentedSieveArray.add(true);
        }

        for(int primeNumber : primeNumbers ){

            int firstMultiple = segmentStart/primeNumber * primeNumber;

            if(firstMultiple < segmentStart){
                firstMultiple+=primeNumber;
            }

            for(int i=firstMultiple; i<=segmentEnd; i+=primeNumber){
                segmentedSieveArray.set(i-segmentStart, false);
            }
        }

        for(int i=0; i<segmentedSieveArray.size(); i++){
            if(segmentedSieveArray.get(i)){
                sum+=(i+segmentStart);
            }
        }

        return sum;

    }

}
