/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.dao;

import com.quiz.entities.User;
import java.util.List;

/**
 *
 * @author Yogendra
 */
public interface IUserDao {
        public abstract void add(User user);
	public abstract User get(long userID);
        public abstract User getUserByName(String username);
}
