/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.controller;

import com.quiz.entities.Question;
import com.quiz.entities.Quiz;
import com.quiz.service.IQuizService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


/**
 *
 * @author Yogendra
 */
@Controller
@SessionAttributes(value={"quiz"})
public class QuizController {

    @Resource
    IQuizService quizService;

    @RequestMapping(value = "/addQuiz", method = RequestMethod.GET)
    public String addQuestionToQuiz(ModelMap model) {
        Quiz quiz = (Quiz) model.get("quiz");
        if (quiz != null) {
            model.put("question", new Question());
            model.put("questions", quiz.getQuestions());
        } else {
            model.put("quiz", new Quiz());
            model.put("question", new Question());
        }

        return "addQuiz";
    }

    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public String addQuiz(Quiz quiz, BindingResult result) {
        System.out.println(quiz.getDisplayName());
        quiz.getQuestions().add(new Question(quiz.getQuestion(), quiz.getSolution()));
        return "redirect:/addQuiz";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveQuiz(Quiz quiz,SessionStatus sessionStatus) {
        
        quizService.storeQuiz(quiz);
        sessionStatus.setComplete();
        return "main";
    }

}
