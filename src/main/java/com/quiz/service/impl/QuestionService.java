/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.service.impl;

import com.quiz.dao.IQuestionDao;
import com.quiz.entities.Question;
import com.quiz.service.IQuestionService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

/**
 *
 * @author Yogendra
 */
@Transactional
public class QuestionService implements IQuestionService{
    IQuestionDao questionDao;
    

    public QuestionService(IQuestionDao questionDao) {
        this.questionDao = questionDao;
    }
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Override
    public void add(Question question) {
        questionDao.add(question);
    }
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Override
    public Question get(int questionId) {
         return questionDao.get(questionId);
    }  
    @Override
	public List<Question> getAll() {
		return questionDao.getAll();
	}
}
