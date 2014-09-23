package com.quiz.entities;

import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class QuizContest extends EntityObject {

    private static final long serialVersionUID = 1L;

    private String name;

    private String gameName;

    private long quizId;

    protected List<Contestant> contestants;
    
    private long contestOwnerId;

    public QuizContest() {

    }

    public long getContestOwnerId() {
        return contestOwnerId;
    }

    public void setContestOwnerId(long contestOwnerId) {
        this.contestOwnerId = contestOwnerId;
    }

   public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
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
