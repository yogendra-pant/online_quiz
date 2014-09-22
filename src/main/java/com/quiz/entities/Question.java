/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author puneetkhanal
 */
@Entity
public class Question extends EntityObject {

//     @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long questionId;
    private String question;
    private String solution;
    private String userAnswer;
    private String fullPoint;
    private String scoredPoint;

    public Question() {

    }

    public Question(String question, String solution) {
        this.question = question;
        this.solution = solution;
    }
     public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public String getFullPoint() {
        return fullPoint;
    }

    public void setFullPoint(String fullPoint) {
        this.fullPoint = fullPoint;
    }

    public String getScoredPoint() {
        return scoredPoint;
    }

    public void setScoredPoint(String scoredPoint) {
        this.scoredPoint = scoredPoint;
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

}
