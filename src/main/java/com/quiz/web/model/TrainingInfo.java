package com.quiz.web.model;



public class TrainingInfo {

    private long contestId;

    private String contestName;

    private String description;

    private int nrOfQuestions = 0;

    private String version;

    public TrainingInfo() {

    }

    public void setContestId(long contestId) {
        this.contestId = contestId;
    }

    public long getContestId() {
        return contestId;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getContestName() {
        return contestName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

}
