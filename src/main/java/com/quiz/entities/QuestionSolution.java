/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author puneetkhanal
 */
@Entity
public class QuestionSolution {

    private long id;
    private String question;
    private String solution;
    private int point;

    public QuestionSolution() {

    }

    public QuestionSolution(String question, String solution, int point) {
        this.question = question;
        this.solution = solution;
        this.point = point;
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

}
