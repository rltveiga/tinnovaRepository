package com.tinnova.tinnovaExercises.excerciseFactorial;

public class Factorial {

    public int factorialRecursive(int x) {
        if (x == 0)
            return 1;
        return x * factorialRecursive(x - 1);
    }
}
