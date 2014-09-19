
import com.quiz.dao.impl.UserDao;
import com.quiz.entity.User;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yogendra
 */
public class UserDaoTest {

    ApplicationContext context = new ClassPathXmlApplicationContext(
            "SpringMVC-servlet.xml");
    UserDao userDao = context
            .getBean("userDao", UserDao.class);

    @Test
    public void addUserTest() {

        User user = new User("abc", "abc", "abc", "abc");
        userDao.add(user);
        Assert.assertTrue(user.getUserId() > 0);
          user=userDao.get(user.getUserId());
          Assert.assertNotNull(user);
         
    }

  
}
