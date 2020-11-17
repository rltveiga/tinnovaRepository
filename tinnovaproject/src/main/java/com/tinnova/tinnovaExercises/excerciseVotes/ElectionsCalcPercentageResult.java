package com.tinnova.tinnovaExercises.excerciseVotes;

public class ElectionsCalcPercentageResult {

    private Election election;

    public Double getValidVotesPercentage() {
        return ((double)this.election.getValidVotes()/this.election.getTotalVoters())*100;
    }


    public Double getBlankVotesPercentage() {
        return ((double) election.getBlankVotes()/ election.getTotalVoters())*100;
    }

    public Double getNullVotesPercentage() {
        return ((double)this.election.getNullVotes()/this.election.getTotalVoters())*100;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

}
