/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.utilities;

/**
 *
 * @author puneetkhanal
 */


import com.quiz.entities.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class PasswordValidator implements Validator{

    private User user;
    
    public PasswordValidator(User user){
        this.user=user;
    }
	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(this.user!=null){
                    errors.rejectValue("userName", "username","username already exists");
                }
		User cust = (User)target;
		
		if(!(cust.getPassword().equals(cust.getConfirmPassword()))){
			errors.rejectValue("password", "notmatch.password","password do not match");
		}
		
	}
	
}
