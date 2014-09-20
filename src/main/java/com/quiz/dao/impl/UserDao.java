/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.dao.impl;

import com.quiz.dao.AbstractDao;
import com.quiz.dao.IUserDao;
import com.quiz.entities.User;
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
public class UserDao extends AbstractDao implements IUserDao {

    public UserDao(SessionFactory sf) {
        super(sf);
    }

    @Override
    public void add(User user) {

        sf.getCurrentSession().save(user);

    }

    @Override
    public User get(long userID) {
        User user = (User) sf.getCurrentSession().get(User.class, userID);
        return user;
    }

}
