/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.dao.impl;

import com.quiz.dao.IUserDao;
import com.quiz.entity.User;
import org.hibernate.SessionFactory;


/**
 *
 * @author Yogendra
 */
public class UserDao implements IUserDao{
    private SessionFactory sf;

    public UserDao() {
    }

    public UserDao(SessionFactory sf) {
        this.sf = sf;
    }
    @Override
    public void add(User user) {
   
    }

    @Override
    public User get(String useName) {
    return new User();
    }

  
    
}
