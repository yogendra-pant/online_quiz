/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.controller;

import com.quiz.dao.IQuestionDao;
import com.quiz.entities.Question;
import com.quiz.service.IQuestionService;
import javax.annotation.Resource;
import javax.validation.Valid;
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
public class QuestionController {
      @Resource
      IQuestionService questionService;
      
//    @RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
//    public String addUser(@ModelAttribute("question") Question question) {
//    return "addQuestion";
//    }
     @RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("questions", questionService.getAll());
         model.addAttribute("question", new Question());
        return "addQuestion";
    }
    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public String addUser(@Valid Question question, BindingResult result) {   
            questionService.add(question);
            System.out.println("question persisted!");
            return "/addQuestion";
    }
   
}
