/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.controller;

import com.quiz.entities.ContestProxy;
import com.quiz.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Yogendra
 */
@Controller
public class ContestController {

    @RequestMapping(value = "/addContest", method = RequestMethod.GET)
    public String addContest(@ModelAttribute("contestProxy") ContestProxy contestProxy) {
        return "addContest";
    }
}
