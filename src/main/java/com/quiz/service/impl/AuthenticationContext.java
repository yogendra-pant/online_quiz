/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.service.impl;

import com.quiz.entities.User;



/**
 *
 * @author puneetkhanal
 */
public class AuthenticationContext {
    
    public static User user;
    public static void setUser(User user){
        user=user;
    }
    
    public static User getCurrentUser(){
        return user;
    }
}
