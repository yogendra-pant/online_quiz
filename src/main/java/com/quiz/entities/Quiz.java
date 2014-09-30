package com.quiz.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Quiz {

    private long id;
    private String name;

    private String displayName;

    private String description;

    private String question;
    private String solution;
    private int point;
    private List<Question> questions = new ArrayList<Question>();

    public Quiz() {

    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    @Transient
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Transient
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Transient
    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Transient
    public int getNrOfQuestions() {
        return questions.size();
    }

    @Override
    public String toString() {
        return getId() + ":" + displayName;
    }

}
