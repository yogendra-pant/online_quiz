package com.quiz.dao.impl;

import com.quiz.dao.AbstractDao;
import com.quiz.dao.IContestDao;
import com.quiz.entities.Contestant;
import com.quiz.entities.QuizContest;
import com.quiz.entities.ScheduledContest;
import com.quiz.entities.TrainingContest;
import com.quiz.web.model.ContestState;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY, rollbackFor = Throwable.class)
public class ContestDao extends AbstractDao implements IContestDao {

    public ContestDao(SessionFactory sf) {
        super(sf);
    }

    @Override
    public List<ScheduledContest> getScheduledContests() {
        List<ScheduledContest> scheduledContests = getQuery("select s from ScheduledContest s").list();
        for (ScheduledContest scheduledContest : scheduledContests) {
            checkStatus(scheduledContest);
        }
        return scheduledContests;

    }

    @Override
    public List<ScheduledContest> getScheduledContestsByState(ContestState state) {
        return getQuery("select s from ScheduledContest s where s.contestState=?", state).list();

    }

    @Override
    public List<TrainingContest> getTrainingContests() {
        return getQuery("select t from TrainingContest t").list();
    }

    @Override
    public QuizContest storeContest(QuizContest contest) {
        sf.getCurrentSession().saveOrUpdate(contest);
        sf.getCurrentSession().flush();
        return contest;
    }

    @Override
    public boolean deleteContest(QuizContest contest) {
        System.out.println("deleting" + contest.getId());
        List<Contestant> contestContestants = getContestants(contest.getId());

        for (Contestant contestant : contestContestants) {

            sf.getCurrentSession().delete(contestant);
        }
        sf.getCurrentSession().delete(contest);
        sf.getCurrentSession().flush();
        return true;
    }

    @Override
    public QuizContest getContest(long contestId) {
        ScheduledContest scheduledContest = (ScheduledContest) sf.getCurrentSession().get(QuizContest.class, contestId);
        checkStatus(scheduledContest);
        return scheduledContest;
    }

    @Override
    public Contestant getContestant(long contestId, long userId) {
        return (Contestant) getQuery("select c from Contestant c where c.contest.id=? and c.user.id=?", contestId, userId).uniqueResult();

    }

    @Override
    public Contestant storeContestant(Contestant t) {
        sf.getCurrentSession().save(t);

        sf.getCurrentSession().flush();
        return t;
    }

    @Override
    public List<Contestant> getContestants(long contestId) {
        return getQuery("select c from Contestant c where c.contest.id=?", contestId).list();
    }

    @Override
    public TrainingContest getTrainingContestByGame(String gameName) {
        return (TrainingContest) getQuery("select t from TrainingContest t where t.gameName=?", gameName).uniqueResult();
    }

    @Override
    public TrainingContest getTrainingContestById(long contestId) {

        return (TrainingContest) getQuery("select t from TrainingContest t where t.id=?", contestId).uniqueResult();
    }

    @Override
    public ContestState getContestState(long contestId) {
        return (ContestState) getQuery("select c.contestState from QuizContest c where c.id=?", contestId).uniqueResult();
    }

    private void checkStatus(ScheduledContest scheduledContest) {
        if(scheduledContest==null||scheduledContest.getStartTime()==null){
            return ;
        }
        if (System.currentTimeMillis() > scheduledContest.getStartTime().getTime()) {
            scheduledContest.setContestState(ContestState.RUNNING);
        }
        Date now = new Date();
        long endTime = scheduledContest.getStartTime().getTime() + ((scheduledContest.getDuration().getHours() * 60 + scheduledContest.getDuration().getMinutes()) * 60000);

        if (endTime < now.getTime()) {
            scheduledContest.setContestState(ContestState.COMPLETED);
        }
    }

    @Override
    public Contestant getContestant(long contestantId) {
        return (Contestant) sf.getCurrentSession().get(Contestant.class, contestantId);
    }

}
