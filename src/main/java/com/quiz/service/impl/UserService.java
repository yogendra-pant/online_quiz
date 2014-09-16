/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.service.impl;

import com.quiz.dao.impl.UserDao;
import com.quiz.service.IUserService;

/**
 *
 * @author Yogendra
 */
public class UserService implements IUserService{
    UserDao userDao;
    
    public UserService() {
    }

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

   
    
    
    
}
