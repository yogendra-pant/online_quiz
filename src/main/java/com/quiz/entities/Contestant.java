package com.quiz.entities;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Contestant {

    private long id;

    private QuizContest contest;

    private User user;

    private long duration;

    private QuizSolution quizSolution;

    private long startTime;

    public Contestant() {

    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public QuizSolution getQuizSolution() {
        return quizSolution;
    }

    public void setQuizSolution(QuizSolution quizSolution) {
        this.quizSolution = quizSolution;
    }

    public void setContest(QuizContest contest) {
        this.contest = contest;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public QuizContest getContest() {
        return contest;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public User getUser() {
        return user;
    }

    @Transient
    public int getTotalPoints() {
        int totalPoint = 0;
        if (quizSolution != null) {
            for (QuestionSolution question : quizSolution.getQuestionSolutions()) {
                totalPoint += question.getPoint();
            }
        }
        return totalPoint;
    }

}
