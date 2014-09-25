package com.quiz;

import com.quiz.entities.Question;
import com.quiz.entities.Quiz;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@Transactional
public class QuizDaoTest extends QuizTestCase {

    @Before
    public void before() throws IOException {

    }

    @Test
    public void availableGames() {
        Quiz quiz = new Quiz();
//        quiz.setCreated(null);
        quiz.setDescription("test quiz");
        quiz.setDisplayName("test");
//        quiz.setCreated(new Date());

        List<Question> questions = new ArrayList<Question>();
        questions.add(new Question("What is your name?", "Puneet Khanal", 1));
        quiz.setQuestions(questions);
        quizDao.storeQuiz(quiz);
        System.out.println(quiz.getId());
        Quiz quiz1 = quizDao.getQuiz(1);
        Assert.assertNotNull(quiz1);
        Assert.assertTrue(quiz1.getQuestions().size() > 0);
    }

}
