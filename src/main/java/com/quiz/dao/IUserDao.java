/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.dao;

import com.quiz.entity.User;
import java.util.List;

/**
 *
 * @author Yogendra
 */
public interface IUserDao {
    
	//public abstract List<User> getAll();

	public abstract void add(User user);

	public abstract User get(String useName);

	//public abstract void update(int userId, User user);

	//public abstract void delete(int userId);
}
