/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.service;

import com.quiz.entities.Question;
import java.util.List;

/**
 *
 * @author Yogendra
 */
public interface IQuestionService {

    public abstract void add(Question question);

    public abstract Question get(int questionId);

    public abstract List<Question> getAll();
}
