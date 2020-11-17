package com.tinnova.tinnovaExercises.excerciseVotes;

public class Election {

    private Integer totalVoters;
    private Integer validVotes;
    private Integer blankVotes;
    private Integer nullVotes;

    public Election(Integer totalVoters, Integer validVotes, Integer blankVotes, Integer nullVotes) {
        this.totalVoters = totalVoters;
        this.validVotes = validVotes;
        this.blankVotes = blankVotes;
        this.nullVotes = nullVotes;
    }

    public Integer getTotalVoters() {
        return totalVoters;
    }

    public Integer getValidVotes() {
        return validVotes;
    }


    public Integer getBlankVotes() {
        return blankVotes;
    }

    public Integer getNullVotes() {
        return nullVotes;
    }
}