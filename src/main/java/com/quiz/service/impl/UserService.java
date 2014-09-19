/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.service.impl;

import com.quiz.dao.IUserDao;
import com.quiz.dao.impl.UserDao;
import com.quiz.entity.User;
import com.quiz.service.IUserService;
import javax.transaction.Transactional;

/**
 *
 * @author Yogendra
 */
public class UserService implements IUserService{
    IUserDao userDao;
    

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Override
    public void add(User user) {
        userDao.add(user);
    }
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    @Override
    public User get(int userID) {
         return userDao.get(userID);
    }   
    
}
