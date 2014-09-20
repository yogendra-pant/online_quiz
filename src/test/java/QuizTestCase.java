
import com.quiz.dao.IContestDao;
import com.quiz.dao.IQuizDao;
import com.quiz.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class QuizTestCase {

    public QuizTestCase() {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        contestDao = context.getBean("contestDao", IContestDao.class);
        userDao = context.getBean("userDao", IUserDao.class);
        quizDao = context.getBean("quizDao", IQuizDao.class);
    }

    @Autowired
    protected IContestDao contestDao;

    @Autowired
    protected IQuizDao quizDao;

    @Autowired
    protected IUserDao userDao;

}
