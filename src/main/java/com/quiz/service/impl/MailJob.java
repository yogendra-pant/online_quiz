/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.service.impl;

import com.quiz.dao.ContestDao;
import com.quiz.entities.Contestant;
import com.quiz.entities.ScheduledContest;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author puneetkhanal
 */
public class MailJob implements Job{

   
    
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        ApplicationMailer mailService=(ApplicationMailer) jec.getJobDetail().getJobDataMap().get("mailService");
        long id=(long) jec.getJobDetail().getJobDataMap().get("contestId");
        ContestDao contestDao=(ContestDao) jec.getJobDetail().getJobDataMap().get("contestDao");
        ScheduledContest s=(ScheduledContest) contestDao.getContest(id);
        System.out.println("sending email contestId:"+s.getId());
        for(Contestant c:s.getContestants()){
            System.out.println("sending email to "+c.getUser().getEmailId());
            mailService.sendMail(c.getUser().getEmailId(), "QuizContest "+s.getGameName()+"is starting in 1 minute.", "QuizContest "+s.getGameName()+"is starting in 1 minute.");
        }
    }
}
