/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.service.impl;

import com.quiz.dao.IContestDao;
import com.quiz.dao.IQuizDao;
import com.quiz.entities.Quiz;

import com.quiz.service.IQuizService;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public class QuizService implements IQuizService {

    private final IQuizDao gameDao;

    private final IContestDao contestDao;

    public QuizService(IQuizDao gameDao, IContestDao contestDao) {
        this.gameDao = gameDao;
        this.contestDao = contestDao;
    }

    @Override
    public void storeQuiz(Quiz quiz) {
        gameDao.storeQuiz(quiz);

    }

}
