package com.tinnova.tinnovaExercises.multipleSum;

public class MultipleSum {

    private static final int parameterThree = 3;
    private static final int parameterFive = 5;

    public Integer multipleSumFiveAndThree(Integer numberToCalc){
        int sum = 0;

        for (int x = 0; numberToCalc > x; x++) {
            if (x%parameterThree == 0 || x%parameterFive == 0) {
                sum +=  x;
            }
        }

        return sum;
    }

}
