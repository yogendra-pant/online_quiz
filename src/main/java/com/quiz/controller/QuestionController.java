/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.controller;

import com.quiz.dao.IQuizDao;
import com.quiz.entities.Quiz;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Yogendra
 */
@Controller
@RequestMapping("/webservice/quizList")
public class QuestionController {

    @Resource
    IQuizDao quizDao;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Quiz> getQuestionList() {
        List<Quiz> quizList = quizDao.getAvailableQuiz(null);
        return quizList;
    }
}
