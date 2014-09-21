/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.dao.impl;

import com.quiz.dao.AbstractDao;
import com.quiz.dao.IQuestionDao;
import com.quiz.entities.Question;
import com.quiz.entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Yogendra
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY,rollbackFor = Throwable.class)
public class QuestionDao extends AbstractDao implements IQuestionDao{
private Map<Integer, Question> questions = new HashMap<>();
    public QuestionDao(SessionFactory sf) {
        super(sf);
    }

    @Override
    public void add(Question question) {
     sf.getCurrentSession().save(question);
    }

    @Override
    public Question get(int questionId) {
        Question question = (Question) sf.getCurrentSession().get(Question.class, questionId);
        return question;
    }
    public List<Question> getAll() {
		return new ArrayList<Question>(questions.values());
	}
    
}
