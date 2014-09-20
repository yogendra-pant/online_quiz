package com.quiz.dao;


import com.quiz.dao.IContestDao;
import com.quiz.entities.Contestant;
import com.quiz.entities.LevelTimer;
import com.quiz.entities.QuizContest;
import com.quiz.entities.ScheduledContest;
import com.quiz.entities.TrainingContest;
import com.quiz.shared.entities.ContestState;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class ContestDao extends AbstractDao implements IContestDao{

    public ContestDao(SessionFactory sf) {
        super(sf);
    }

 
	

	@Override
	public List<ScheduledContest> getScheduledContests() {
            return getQuery("select s from ScheduledContest s").list();
		
	}

	@Override
	public List<ScheduledContest> getScheduledContestsByState(ContestState state) {
            return getQuery("select s from ScheduledContest s where s.contestState=?",state).list();
		
	}

	@Override
	public List<TrainingContest> getTrainingContests() {
		return getQuery("select t from TrainingContest t").list();
	}

	@Override
	public QuizContest storeContest(QuizContest contest) {
		sf.getCurrentSession().save(contest);
                return contest;
	}

	@Override
	public boolean deleteContest(QuizContest contest) {
		List<Contestant> contestContestants = getContestants(contest.getId());

		for (Contestant contestant : contestContestants) {
			List<LevelTimer> levelTimer = getLevelTime(contestant.getId());
			for (LevelTimer timer : levelTimer) {
				sf.getCurrentSession().delete(timer);
			}
			sf.getCurrentSession().delete(contestant);
		}
		sf.getCurrentSession().delete(contest);
		return true;
	}

	@Override
	public QuizContest getContest(long contestId) {
		return (QuizContest) sf.getCurrentSession().get(QuizContest.class, contestId);
	}

	@Override
	public Contestant getContestant(long contestId, long userId) {
		return (Contestant) getQuery("select c from Contestant c where c.contest.id=? and c.user.id=?", contestId, userId).uniqueResult();

	}

	@Override
	public Contestant storeContestant(Contestant t) {
		sf.getCurrentSession().save(t);
                return  t;
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
	public LevelTimer storeLevelTimer(LevelTimer l) {
		sf.getCurrentSession().save(l);
                return l;
	}

	@Override
	public List<LevelTimer> getLevelTime(long contestantId) {
		return getQuery("select l from LevelTimer l where l.contestant.id=?", contestantId).list();
	}

	@Override
	public TrainingContest getTrainingContestById(long contestId) {

		return (TrainingContest) getQuery("select t from TrainingContest t where t.id=?", contestId).uniqueResult();
	}
	

	@Override
	public ContestState getContestState(long contestId) {
		return (ContestState) getQuery("select c.contestState from QuizContest c where c.id=?", contestId).uniqueResult();
	}

}
