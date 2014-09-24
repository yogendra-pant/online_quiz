/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.service.impl;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author puneetkhanal
 */
public class MailJob implements Job {

    public void execute(JobExecutionContext jec) throws JobExecutionException {
        ApplicationMailer mailService = (ApplicationMailer) jec.getJobDetail().getJobDataMap().get("mailService");
        String emailId = (String) jec.getJobDetail().getJobDataMap().get("emailId");
        String name = (String) jec.getJobDetail().getJobDataMap().get("name");
        System.out.println("sending email to "+emailId);
        mailService.sendMail(emailId, "QuizContest " + name + " is starting in 1 minute.", "QuizContest " +name + " is starting in 1 minute.");
    }
}
