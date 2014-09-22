package com.quiz.annotations;

;
import com.quiz.dao.IQuizDao;
import com.quiz.entities.Question;
import com.quiz.entities.Quiz;
import java.text.ParseException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App {



    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IQuizDao quizDao = context.getBean("quizDao", IQuizDao.class);
        Transaction tx = null;
        Session session = null;

       
            
          

            Quiz quiz = new Quiz();
            quiz.setDisplayName("abc");
            quiz.setDescription("abc");
          
            Question question1 = new Question("question1", "solution1");
            Question question2 = new Question("question2", "solution2");
            Question question3 = new Question("question3", "solution3");
            quiz.getQuestions().add(question1);
            quiz.getQuestions().add(question2);
            quiz.getQuestions().add(question3);
            quizDao.storeQuiz(quiz);
         
       
    }
}
