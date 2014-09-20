package com.quiz.entities;

import java.io.Serializable;

public class Participant implements Serializable, Comparable<Participant> {

    private static final long serialVersionUID = 1L;

    private int rank;

    private String name;

    private String completedTime;

    private String completedDate;

    private int questionsCompleted;

    private String email;

    public Participant(int rank, String name, String completedTime, String completedDate, int questionsCompleted, String email) {
        this.rank = rank;
        this.name = name;
        this.completedTime = completedTime;
        this.completedDate = completedDate;
        this.questionsCompleted = questionsCompleted;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(String completedTime) {
        this.completedTime = completedTime;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public int getQuestionsCompleted() {
        return questionsCompleted;
    }

    public void setQuestionsCompleted(int questionsCompleted) {
        this.questionsCompleted = questionsCompleted;
    }

    public int compareTo(Participant coder) {
        Integer r = new Integer(this.rank);
        if (rank == -1 && coder.getRank() > 0) {
            return 1;
        } else if (rank > 0 && coder.getRank() == -1) {
            return -1;
        } else if (rank == coder.getRank()) {
            return name.compareTo(coder.getName());
        }
        return r.compareTo(coder.getRank());

    }
}
