package com.quiz.service.impl;

import com.quiz.dao.IContestDao;
import com.quiz.dao.IQuizDao;
import com.quiz.dao.IUserDao;
import com.quiz.entities.Contestant;
import com.quiz.entities.LevelTimer;
import com.quiz.entities.Quiz;
import com.quiz.entities.QuizContest;
import com.quiz.entities.QuizSolution;
import com.quiz.entities.ScheduledContest;

import com.quiz.entities.TrainingContest;

import com.quiz.entities.User;
import com.quiz.service.IContestService;
import com.quiz.shared.entities.ContestInfo;
import com.quiz.shared.entities.ContestState;
import com.quiz.shared.entities.LevelInfo;
import com.quiz.shared.entities.LevelTime;
import com.quiz.shared.entities.Result;
import com.quiz.shared.entities.ScheduleContestResult;
import com.quiz.shared.entities.UserTime;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ContestService implements IContestService {
    
    private final IContestDao contestDao;
    private final IQuizDao quizDao;
    private final IUserDao userDao;
    
    public ContestService(IContestDao contestDao, IQuizDao quizDao,IUserDao userDao) {
        this.contestDao = contestDao;
        this.quizDao = quizDao;
        this.userDao=userDao;
    }
    
    
    
    @Override
    public boolean isRegistered(long contestId) {
        Contestant c = getContestant(contestId);
        return c != null;
    }
    
    @Override
    public Result joinContest(long contestId) {
        
        QuizContest c = contestDao.getContest(contestId);
        if (c == null) {
            return Result.Failure;
        }
        if (!isRegistered(contestId)) {
            Contestant ct = new Contestant();
            ct.setContest(c);
            User user=getUser();
            ct.setUser(user);
            
            if (ct.getUser() == null) {
                return Result.Failure;
            }
            if (c instanceof ScheduledContest) {
                ScheduledContest contest = (ScheduledContest) c;
                ct.setStartTime(contest.getStartTime().getTime());
                
            }
            contestDao.storeContestant(ct);
            c.getContestants().add(ct);
            contestDao.storeContest(c);
            System.out.println("success joing contest by username "+ct.getUser().getUserName());
            return Result.Success;
        }
        
        return Result.Success;
    }
    
    @Override
    public ScheduleContestResult scheduleContest(ContestInfo contestInfo) {
        if (contestInfo.getContestDate().getTime() < (System.currentTimeMillis())) {
             System.out.println(ScheduleContestResult.StartDateInvalid);
            return ScheduleContestResult.StartDateInvalid;
        }
        
        ScheduledContest s = new ScheduledContest();
//        s.setGameName(contestInfo.getGameName());
        s.setName(contestInfo.getContestName());
        
        long date = contestInfo.getContestDate().getTime();
        s.setStartTime(new Date(date));
        System.out.println("contest service:" + contestInfo.getQuizName());
        String[] args = contestInfo.getQuizName().split(":");
        System.out.println(args.length);
        Long id = Long.parseLong(args[0]);
        System.out.println(id);
        s.setContestOwnerId(getUser().getId());
        s.setQuizId(id);
        s.setQuizId(id.intValue());
        s.setDuration(contestInfo.getContestDuration());
        s.setContestState(ContestState.OPEN_FOR_REGISTRATION);
        s.setOrganizer(contestInfo.getOrganizerName());
        s.setOrganizerEmail(contestInfo.getOrganizerEmail());
        
        contestDao.storeContest(s);
        
        return ScheduleContestResult.Success;
    }
    
    @Override
    public boolean deleteContest(long contestId) {
        QuizContest c = contestDao.getContest(contestId);
        contestDao.deleteContest(c);
        return true;
    }
        
    @Override
    public void submitResults(QuizSolution quizSolution, long contestId) {
       Contestant c= getContestant(contestId);
       c.setQuizSolution(quizSolution);
       contestDao.storeContestant(c);
       System.out.println("persisted"+c.getQuizSolution().getId());
    }
    
    private String trim(String string) {
        if (string == null) {
            return null;
        }
        return string.trim();
    }
    
    private Contestant getContestant(long contestId) {
       User user=getUser();
        return contestDao.getContestant(contestId, user.getId());
        
    }
    
    @Override
    public User getUser() {
        User user =userDao.getUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
       return user;
    }
    
    @Override
    public boolean isGameFinished(long contestId) {
        Contestant contestant = getContestant(contestId);
        return contestant.isFinished();
    }
    
    @Override
    public Contestant getContestantInfo(long contestId) {
     User user=userDao.getUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
        return contestDao.getContestant(contestId, user.getId());
        
    }
    
    @Override
    public List<Contestant> getContestants(long contestId) {
        return contestDao.getContestants(contestId);
    }
    
    @Override
    public ScheduleContestResult updateContest(ContestInfo contestInfo) {
        if (contestInfo.getContestDate().getTime() < (System.currentTimeMillis())) {
           
            return ScheduleContestResult.StartDateInvalid;
        }
        ScheduledContest s = (ScheduledContest) contestDao.getContest(contestInfo.getContestId());
        
        s.setName(contestInfo.getContestName());
        System.out.println("updated contest name:"+contestInfo.getContestName());
        long date = contestInfo.getContestDate().getTime();
        s.setStartTime(new Date(date));
        String[] args = contestInfo.getQuizName().split(":");
        Long id = Long.parseLong(args[0]);
        s.setQuizId(id);
        s.setDuration(contestInfo.getContestDuration());
        s.setContestState(ContestState.OPEN_FOR_REGISTRATION);
        s.setOrganizer(contestInfo.getOrganizerName());
        s.setOrganizerEmail(contestInfo.getOrganizerEmail());

        contestDao.storeContest(s);
        
        return ScheduleContestResult.Success;
    }

    
    
  
 
    
}
