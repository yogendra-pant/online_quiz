
import com.quiz.dao.impl.QuizDao;
import com.quiz.entities.Question;
import com.quiz.entities.Quiz;
import com.quiz.entities.Visibility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import junit.framework.Assert;
import static org.junit.Assert.assertEquals;

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
        quiz.setCreated(null);
        quiz.setDescription("test quiz");
        quiz.setDiplayName("test");
        quiz.setCreated(new Date());
        
        List<Question> questions=new ArrayList<Question>();
        questions.add(new Question("What is your name?","Puneet Khanal"));
        quiz.setQuestions(questions);
        quizDao.storeQuiz(quiz);
        System.out.println(quiz.getId());
        Quiz quiz1 = quizDao.getQuiz(quiz.getId());
        Assert.assertNotNull(quiz1);
    }

}
