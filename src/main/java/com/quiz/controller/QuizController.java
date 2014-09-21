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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Yogendra
 */
@Controller
public class QuizController {
    @Resource
    IQuizService quizService;
    
     @RequestMapping(value = "/addQuiz", method = RequestMethod.GET)
    public String addQuestionToQuiz(ModelMap model) {
//        if(!model.containsAttribute("quiz")){
//            model.put("quiz", new Quiz());
//            model.put("question", new Question());
//        }else{
        
            Quiz quiz=(Quiz) model.get("quiz");
            if(quiz!=null){
            for(Question question:quiz.getQuestions()){
                System.out.println(question.getQuestion() );
            }
            System.out.println(quiz.getName());
           
            model.put("question", new Question());
            model.put("questions", quiz.getQuestions());
            }else{
//                model.put("quiz", new Quiz());
            model.put("question", new Question());
            }
//        }
    return "addQuiz";
    }
    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public String addQuiz(Quiz quiz,Question question,BindingResult result,RedirectAttributes redirectAttributes) {   
            quiz.getQuestions().add(question);
            redirectAttributes.addFlashAttribute(quiz);
            System.out.println("quiz persisted!");
            return "redirect:/addQuiz";
    }
    
    
    
    
    
}
