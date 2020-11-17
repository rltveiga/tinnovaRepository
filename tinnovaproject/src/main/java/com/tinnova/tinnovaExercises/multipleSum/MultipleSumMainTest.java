package com.tinnova.tinnovaExercises.multipleSum;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultipleSumMainTest {

    private static final Logger LOGGER =  LogManager.getLogger(MultipleSumMainTest.class);

    public static void main(String[] args) {
        MultipleSum multipleSum = new MultipleSum();
        int valueToCalc = 10;
        LOGGER.info("Soma dos Multiplos de 3 e 5 até "+valueToCalc+": "+multipleSum.multipleSumFiveAndThree(valueToCalc));
    }
}
