/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.controller;

import com.quiz.dao.IUserDao;
import com.quiz.entities.User;
import com.quiz.service.IUserService;
import com.quiz.validation.constraints.PasswordValidator;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Yogendra
 */
@Controller
public class UserController {

    @Resource
    IUserService userService;
    
    @Autowired
    IUserDao userDao;

    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("user") User user) {
        return "registerUser";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result) {
        String view = "login";
        
        PasswordValidator passwordValidator=new PasswordValidator(userDao.getUserByName(user.getUserName()));
        passwordValidator.validate(user, result);
        
        if (!result.hasErrors()) {

            userService.add(user);

            //  result.addError();
            System.out.println("password mismatch!");
        } else {
            view = "/registerUser";
        }
        return view;
    }

}
