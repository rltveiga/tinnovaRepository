package com.tinnova.tinnovaExercises.exerciseBubbleSort;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchAndOrdering {

    private static final Logger LOGGER =  LogManager.getLogger(SearchAndOrdering.class);

    public int[] bublleSort(int[] vectorToOrder) {
        int aux = 0;
        int i = 0;

        for (i = 0; i < vectorToOrder.length; i++) {
            for (int j = 0; j < vectorToOrder.length-1; j++) {
                if (vectorToOrder[j] > vectorToOrder[j + 1]) {
                    aux = vectorToOrder[j];
                    vectorToOrder[j] = vectorToOrder[j + 1];
                    vectorToOrder[j + 1] = aux;
                }
            }
        }

        this.printVector(vectorToOrder);
        return vectorToOrder;
    }

    public void printVector(int[] vector){
        int i = 0;
        LOGGER.info("Vetor organizado:");
        for (i = 0; i < vector.length; i++) {
            System.out.print(" " + vector[i]);
        }
    }

}
