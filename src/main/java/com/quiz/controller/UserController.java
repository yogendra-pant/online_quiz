/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.controller;

import com.quiz.dao.IUserDao;
import com.quiz.entity.User;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    IUserDao userDao;
    @RequestMapping("/")
    public String redirectRoot() {
        return "redirect:/registerUser";
    }
    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("user") User user) {
    return "registerUser";
    }
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String addUser(@Valid User user, BindingResult result) {        
        System.out.println("register user");
        String view="success";
        if(!result.hasErrors()){
          userDao.add(user);
        }else{
            view="/registerUser";
        }
                return view;
    }
   
}
