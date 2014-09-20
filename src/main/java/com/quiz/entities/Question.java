/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.entities;

import javax.persistence.Entity;

/**
 *
 * @author puneetkhanal
 */
@Entity 
public class Question extends EntityObject{

    private String question;
    private String solution;
    public Question(){
        
    }
    
    public Question(String question,String solution){
        this.question=question;
        this.solution=solution;
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
