/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.service;

import com.quiz.entity.User;

/**
 *
 * @author Yogendra
 */
public interface IUserService {

    public abstract void add(User user);

    public abstract User get(int userID);

}
