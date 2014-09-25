package com.quiz;

import com.quiz.dao.IContestDao;
import com.quiz.dao.IQuizDao;
import com.quiz.dao.IUserDao;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@TransactionConfiguration
@Transactional
public class QuizTestCase {

    @Autowired
    protected IContestDao contestDao;

    @Autowired
    protected IQuizDao quizDao;

    @Autowired
    protected IUserDao userDao;

}
