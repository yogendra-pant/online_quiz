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
public class QuizSolution{

    private long id;

    private String name;

    private String displayName;

    private String description;

    private String question;
    private String solution;
    private int point;

    private List<QuestionSolution> questionSolutions = new ArrayList<QuestionSolution>();

    public QuizSolution() {

    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public final void setId(long id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

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
    public List<QuestionSolution> getQuestionSolutions() {
        return questionSolutions;
    }

    public void setQuestionSolutions(List<QuestionSolution> questionSolutions) {
        this.questionSolutions = questionSolutions;
    }

    @Transient
    public int getNrOfQuestions() {
        return questionSolutions.size();
    }

    @Override
    public String toString() {
        return getId() + ":" + displayName;
    }

}
