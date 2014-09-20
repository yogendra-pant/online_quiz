/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.dao.impl;

import com.quiz.dao.IUserDao;
import com.quiz.entities.User;
import javax.transaction.Transactional;
import org.hibernate.SessionFactory;


/**
 *
 * @author Yogendra
 */
 @Transactional
public class UserDao implements IUserDao{
    private SessionFactory sf;


    public UserDao(SessionFactory sf) {
        this.sf = sf;
    }
   
    @Override
    public void add(User user) {
        sf.getCurrentSession().persist(user);
       
    }

    @Override
    public User get(long userID) {
    User user= (User)sf.getCurrentSession().get(User.class, userID);  
    return user;
    }

    

 
    
}
