package com.quiz.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class QuizContest extends EntityObject {

    private static final long serialVersionUID = 1L;

    private String name;

    private String gameName;

    private Quiz quiz;

    protected List<Contestant> contestants;

    public QuizContest() {

    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

   

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setContestants(List<Contestant> contestants) {
        this.contestants = contestants;
    }

    @Transient
    public abstract List<Contestant> getContestants();

}
