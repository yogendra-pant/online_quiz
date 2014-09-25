package com.quiz;

import com.quiz.entities.User;
import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yogendra
 */
@Ignore
public class UserDaoTest extends QuizTestCase {

    @Test
    public void addUserTest() {

        User user = new User();
        user.setUserName("puneet");
        user.setEmailId("puneetkhanal@gmail.com");
        user.setPhoneNumber("9841684566");
        user.setPassword("hello");
        userDao.add(user);
        Assert.assertTrue(user.getId() == 1);
        user = userDao.get(user.getId());
        Assert.assertNotNull(user);

    }

}
