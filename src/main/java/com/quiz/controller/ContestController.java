/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.controller;

import com.quiz.dao.IContestDao;
import com.quiz.dao.IQuizDao;
import com.quiz.dao.IUserDao;
import com.quiz.entities.Contestant;
import com.quiz.entities.Question;
import com.quiz.entities.QuizContest;
import com.quiz.entities.ScheduledContest;
import com.quiz.entities.User;
import com.quiz.entities.Visibility;
import com.quiz.service.IContestService;
import com.quiz.service.impl.AuthenticationContext;
import com.quiz.shared.entities.ContestInfo;
import com.quiz.shared.entities.ContestState;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ContestController {

    @Autowired
    private IContestService contestService;

    @Autowired
    private IContestDao contestDao;

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IQuizDao quizDao;

    @RequestMapping("/")
    public String redirectRoot() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getScheduledContests(Model model) {
        List<ScheduledContest> contests = contestDao.getScheduledContests();
        System.out.println(contests.size());
        model.addAttribute("contests", contests);
        return "main";
    }

    @RequestMapping(value = "/addContest", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("contestInfo") ContestInfo contestInfo, ModelMap model) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        contestInfo.setContestDate(cal.getTime());
        contestInfo.setContestName("test");
        contestInfo.setOrganizerEmail("puneetkhanal@gmail.com");
        contestInfo.setOrganizerName("puneet");
        contestInfo.setContestDuration(new Date(System.currentTimeMillis() / 1000));
        model.addAttribute("quizList", quizDao.getAvailableQuiz(Visibility.Public));
        return "addContest";
    }

    @RequestMapping(value = "/addContest", method = RequestMethod.POST)
    public String addUser(@Valid ContestInfo contestInfo, BindingResult result) {
        String view = "redirect:main";
        if (!result.hasErrors()) {
            System.out.println(contestInfo.getContestDate());
            System.out.println(" validated inputs of contest: " + contestInfo.getContestName());
            System.out.println(contestInfo.getQuizName());
            contestService.scheduleContest(contestInfo);
        } else {
            System.out.println(contestInfo.getContestDate());
            view = "/addContest";
        }
        return view;
    }

    @RequestMapping(value = "/detailsClick", method = RequestMethod.POST)
    public String details(int contestId, ModelMap model) {
        model.addAttribute("contest", contestDao.getContest(contestId));
        Contestant c=contestService.getContestantInfo(contestId);
        model.addAttribute("joined",c);
        return "contest";
    }

    @RequestMapping(value = "/detailsClick", method = RequestMethod.GET)
    public String getdetails(ModelMap model) {
        Integer contestId=(Integer) model.get("contestId");
        QuizContest contest=contestDao.getContest(contestId);
        model.addAttribute("contest", contest);
        Contestant c=contestService.getContestantInfo(contestId);
        model.addAttribute("joined",c);
        return "contest";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String getdetails(int contestId, RedirectAttributes redirectAttributes) {
        contestService.joinContest(contestId);
        redirectAttributes.addFlashAttribute("contestId", contestId);
        return "redirect:/detailsClick";
    }

    @RequestMapping(value = "/enter", method = RequestMethod.POST)
    public String quiz(int contestId, ModelMap model) {
        QuizContest quizContest = contestDao.getContest(contestId);
        System.out.println("quiz_id" + quizContest.getQuizId());
        List<Question> questions = quizDao.getQuiz(quizContest.getQuizId()).getQuestions();
        System.out.println("questions size:" + questions.size());
        model.addAttribute("questions", questions);
        return "quiz";
    }

}
