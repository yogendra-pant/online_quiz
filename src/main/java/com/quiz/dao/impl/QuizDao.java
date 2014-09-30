package com.quiz.dao.impl;

import com.quiz.dao.AbstractDao;
import com.quiz.dao.IQuizDao;
import com.quiz.entities.Quiz;
import com.quiz.entities.QuizSolution;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
public class QuizDao extends AbstractDao implements IQuizDao {

    public QuizDao() {
        super(null);
    }

    public QuizDao(SessionFactory sf) {
        super(sf);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return getQuery("select q from Quiz q").list();
    }

    @Override
    public void storeQuiz(Quiz quiz) {
        try {

            sf.getCurrentSession().save(quiz);
            sf.getCurrentSession().flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Quiz getQuiz(long id) {
        Quiz quiz = null;
        try {
            quiz = (Quiz) sf.getCurrentSession().get(Quiz.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return quiz;
        }
        return quiz;
    }

    @Override
    public void updateQuiz(Quiz quiz) {
        sf.getCurrentSession().save(quiz);
    }

    @Override
    public void deleteQuiz(Quiz quiz) {
        sf.getCurrentSession().save(quiz);
    }

    @Override
    public void storeQuizSolution(QuizSolution quiz) {
        try {

            sf.getCurrentSession().save(quiz);
            sf.getCurrentSession().flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
