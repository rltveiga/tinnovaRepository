package com.tinnova.tinnovaExercises.excerciseFactorial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FactorialMainTest {

    private static final Logger LOGGER =  LogManager.getLogger(FactorialMainTest.class);

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        LOGGER.info("Fatorial de 0: "+factorial.factorialRecursive(0));
        LOGGER.info("Fatorial de 1: "+factorial.factorialRecursive(1));
        LOGGER.info("Fatorial de 2: "+factorial.factorialRecursive(2));
        LOGGER.info("Fatorial de 3: "+factorial.factorialRecursive(3));
        LOGGER.info("Fatorial de 4: "+factorial.factorialRecursive(4));
        LOGGER.info("Fatorial de 5: "+factorial.factorialRecursive(5));
        LOGGER.info("Fatorial de 6: "+factorial.factorialRecursive(6));
    }
}
