package com.tinnova.tinnovaExercises.excerciseVotes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ElectionsMainTest {

    private static final Logger LOGGER =  LogManager.getLogger(ElectionsMainTest.class);

    public static void main(String[] args) {

        Election election = new Election(1000, 800, 150, 50);
        ElectionsCalcPercentageResult calcResultByElection = new ElectionsCalcPercentageResult();

        calcResultByElection.setElection(election);

        LOGGER.info("Total de Votos: "+calcResultByElection.getElection().getTotalVoters());
        LOGGER.info("Porcentagem de Votos Validos: "+calcResultByElection.getValidVotesPercentage()+"%");
        LOGGER.info("Porcentagem de Votos em Branco: "+calcResultByElection.getBlankVotesPercentage()+"%");
        LOGGER.info("Porcentagem de Votos Nulos: "+calcResultByElection.getNullVotesPercentage()+"%");

    }

}
