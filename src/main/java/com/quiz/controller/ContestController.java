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
import com.quiz.entities.QuestionSolution;
import com.quiz.entities.Quiz;
import com.quiz.entities.QuizContest;
import com.quiz.entities.QuizSolution;
import com.quiz.entities.ScheduledContest;
import com.quiz.service.IContestService;
import com.quiz.web.model.ContestInfo;
import java.util.Calendar;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Yogendra
 */
@Controller
@SessionAttributes(value = {"quizList"})
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
        Collections.reverse(contests);
        model.addAttribute("contests", contests);
        return "main";
    }

    @RequestMapping(value = "/addContest", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("contestInfo") ContestInfo contestInfo, ModelMap model) {
        if (model.get("contestId") == null) {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(System.currentTimeMillis());
            contestInfo.setContestDate(cal.getTime());
            contestInfo.setContestName("test");
            contestInfo.setOrganizerEmail("puneetkhanal@gmail.com");
            contestInfo.setOrganizerName("puneet");
            contestInfo.setContestDuration(new Date(System.currentTimeMillis() / 1000));
        } else {

            ScheduledContest contest = (ScheduledContest) contestDao.getContest((Integer) model.get("contestId"));
            contestInfo.setContestDate(contest.getStartTime());
            contestInfo.setContestName(contest.getName());
            contestInfo.setOrganizerEmail(contest.getOrganizerEmail());
            contestInfo.setOrganizerName(contest.getOrganizer());
            contestInfo.setContestDuration(contest.getDuration());

            contestInfo.setContestId(contest.getId());
        }
        model.addAttribute("quizList", quizDao.getAllQuiz());
        return "addContest";
    }

    @RequestMapping(value = "/addContest", method = RequestMethod.POST)
    public String addUser(@Valid ContestInfo contestInfo, BindingResult result, SessionStatus sessionStatus) {
        String view = "redirect:main";
        if (!result.hasErrors()) {
            if (contestInfo.getContestId() > 0) {
                contestService.updateQuizContest(contestInfo);
            } else {
                contestService.scheduleQuizContest(contestInfo);
            }
            sessionStatus.setComplete();
        } else {
            System.out.println(contestInfo.getContestDate());
            view = "/addContest";
        }
        return view;
    }

    @RequestMapping(value = "/detailsClick", method = RequestMethod.POST)
    public String details(int contestId, ModelMap model) {
        ScheduledContest contest = (ScheduledContest) contestDao.getContest(contestId);
        model.addAttribute("contest", contest);
        Contestant c = contestService.getContestantInfo(contestId);
        if (c == null) {
            model.addAttribute("joined", false);
        } else {
            model.addAttribute("joined", true);
        }
        if (contest.getContestOwnerId() == contestService.getUser().getId()) {
            model.addAttribute("admin", true);
        } else {
            model.addAttribute("admin", false);
        }
        int totalPoint = 0;
        Quiz quiz = quizDao.getQuiz(contest.getQuizId());
        for (Question question : quiz.getQuestions()) {
            totalPoint += question.getPoint();
        }
        model.addAttribute("totalPoint", totalPoint);
        return "contest";
    }

    @RequestMapping(value = "/detailsClick", method = RequestMethod.GET)
    public String getdetails(Integer contestId, ModelMap model) {
        if (contestId == null) {
            contestId = (Integer) model.get("contestId");
        }
        QuizContest contest = contestDao.getContest(contestId);
        model.addAttribute("contest", contest);
        Contestant c = contestService.getContestantInfo(contestId);
        if (c == null) {
            model.addAttribute("joined", false);
        } else {
            model.addAttribute("joined", true);
        }
        System.out.println("joined" + model.get("joined"));
        System.out.println(contest.getContestOwnerId() + ":" + contestService.getUser().getId());
        if (contest.getContestOwnerId() == contestService.getUser().getId()) {
            model.addAttribute("admin", true);
            System.out.println("admin" + true);
        } else {
            model.addAttribute("admin", false);
        }
        int totalPoint = 0;
        Quiz quiz = quizDao.getQuiz(contest.getQuizId());
        for (Question question : quiz.getQuestions()) {
            totalPoint += question.getPoint();
        }
        model.addAttribute("totalPoint", totalPoint);
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
        Quiz quiz = quizDao.getQuiz(quizContest.getQuizId());
//        List<Question> questions = quizDao.getQuiz(quizContest.getQuizId()).getQuestions();

        QuizSolution newQuiz = new QuizSolution();
        newQuiz.setDescription(quiz.getDescription());
        newQuiz.setDisplayName(quiz.getDisplayName());
        newQuiz.setName(quiz.getName());

        for (Question question : quiz.getQuestions()) {
            newQuiz.getQuestionSolutions().add(new QuestionSolution(question.getQuestion(), "", question.getPoint()));
        }
        model.addAttribute("quizSolution", newQuiz);
        model.addAttribute("contestId", contestId);
        return "quiz";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editContest(int contestId, RedirectAttributes redirectAttributes) {
        contestService.joinContest(contestId);
        redirectAttributes.addFlashAttribute("contestId", contestId);
        return "redirect:/addContest";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteContest(int contestId) {
        contestService.deleteContest(contestId);

        return "redirect:/main";
    }

}
