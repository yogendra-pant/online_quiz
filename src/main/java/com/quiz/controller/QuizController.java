/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.controller;

import com.quiz.dao.IContestDao;
import com.quiz.dao.IQuizDao;
import com.quiz.entities.Contestant;
import com.quiz.entities.Question;
import com.quiz.entities.QuestionSolution;
import com.quiz.entities.Quiz;
import com.quiz.entities.QuizSolution;
import com.quiz.service.IContestService;
import com.quiz.service.IQuizService;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Yogendra
 */
@Controller
@SessionAttributes(value = {"quiz"})
public class QuizController {

    @Resource
    IQuizService quizService;

    @Autowired
    IContestService contestService;

    @Autowired
    IContestDao contestDao;

    @Autowired
    IQuizDao quizDao;

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
        quiz.getQuestions().add(new Question(quiz.getQuestion(), quiz.getSolution(), quiz.getPoint()));
        return "redirect:/addQuiz";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveQuiz(Quiz quiz, SessionStatus sessionStatus) {
        quizService.storeQuiz(quiz);
        sessionStatus.setComplete();
        return "redirect:/main";
    }

    @RequestMapping(value = "/submitQuiz", method = RequestMethod.POST)
    public String saveQuizSolution(int contestId, QuizSolution quizSolution, SessionStatus sessionStatus) {
        for (QuestionSolution question : quizSolution.getQuestionSolutions()) {
            System.out.println("solutions" + question.getSolution());
        }
        //to doo think why quiz solution is not persisted
        quizDao.storeQuizSolution(quizSolution);
        contestService.submitResults(quizSolution, contestId);
        sessionStatus.setComplete();
        return "redirect:/main";
    }

    @RequestMapping(value = "/viewsolution", method = RequestMethod.POST)
    public String viewSolution(int contestantId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("contestantId", contestantId);
        return "redirect:/viewsolution";
    }

    @RequestMapping(value = "/viewsolution", method = RequestMethod.GET)
    public String viewSolutionGet(ModelMap model) {
        Contestant contestant = contestDao.getContestant((Integer) model.get("contestantId"));
        model.addAttribute("quizSolution", contestant.getQuizSolution());
        model.addAttribute("quiz", quizDao.getQuiz(contestant.getContest().getQuizId()));
        model.addAttribute("contestantId", model.get("contestantId"));
        return "viewsolution";
    }

    @RequestMapping(value = "/submitGrade", method = RequestMethod.POST)
    public String viewSolutionGet(QuizSolution quizSolution, int contestantId) {
        QuizSolution quizsol = contestDao.getContestant(contestantId).getQuizSolution();
        int index = 0;
        for (QuestionSolution question : quizSolution.getQuestionSolutions()) {
            QuestionSolution target = quizsol.getQuestionSolutions().get(index++);
            target.setPoint(question.getPoint());
        }
        quizDao.storeQuizSolution(quizsol);
        return "redirect:/main";
    }

}
