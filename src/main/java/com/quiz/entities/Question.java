/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author puneetkhanal
 */
@Entity
public class Question{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionId;
    @NotNull
    @NotEmpty
    private String question;
    @NotNull
    @NotEmpty
    private String solution;

    

    public Question() {

    }

    

    public Question(String question, String solution) {
        this.question = question;
        this.solution = solution;
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
