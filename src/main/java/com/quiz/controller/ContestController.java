/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.controller;

import com.quiz.dao.IContestDao;
import com.quiz.entities.ScheduledContest;
import com.quiz.service.IContestService;
import com.quiz.shared.entities.ContestInfo;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ContestController {

    @Autowired
    private IContestService contestService;
    
    @Autowired 
    private IContestDao contestDao;
    
    @RequestMapping("/")
    public String redirectRoot() {
        return "redirect:/main";
    }
    
    
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getScheduledContests(Model model) {
        List<ScheduledContest> contests=contestDao.getScheduledContests();
        System.out.println(contests.size());
        model.addAttribute("contests", contests);
        return "main";
    }
    
    @RequestMapping(value = "/addContest", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("contestInfo") ContestInfo contestInfo) {
        return "addContest";
    }

    @RequestMapping(value = "/addContest", method = RequestMethod.POST)
    public String addUser(@Valid ContestInfo contestInfo, BindingResult result) {
        String view = "redirect:main";
        if (!result.hasErrors()) {
            System.out.println(" validated inputs of contest: " + contestInfo.getContestName());
            contestService.scheduleContest(contestInfo);
        } else {
            view = "/addContest";
        }
        return view;
    }

}
