package com.quiz;



import com.quiz.dao.IContestDao;
import com.quiz.entities.QuizContest;
import com.quiz.entities.Contestant;
import com.quiz.entities.LevelTimer;
import com.quiz.entities.ScheduledContest;
import com.quiz.entities.TrainingContest;
import com.quiz.shared.entities.ContestState;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;



public class MockContestDao implements IContestDao {

	private final Map<Long, QuizContest> contests = new HashMap<Long, QuizContest>();
	private final Map<Long, Contestant> contestants = new HashMap<Long, Contestant>();
	private final AtomicLong contestantId = new AtomicLong(1);

	@Override
	public boolean deleteContest(QuizContest contest) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QuizContest getContest(long contestId) {
		return contests.get(contestId);
	}


	@Override
	public Contestant getContestant(long contestId, long userId) {
		for (Contestant c : contestants.values()) {
			if (c.getUser().getId() == userId && c.getContest().getId() == contestId) {
				return c;
			}
		}
		return null;
	}

	@Override
	public List<Contestant> getContestants(long contestId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<LevelTimer> getLevelTime(long contestantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduledContest> getScheduledContests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ScheduledContest> getScheduledContestsByState(ContestState state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TrainingContest getTrainingContestByGame(String gameName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TrainingContest getTrainingContestById(long contestId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrainingContest> getTrainingContests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuizContest storeContest(QuizContest contest) {
		contests.put(contest.getId(), contest);
		return contest;
	}

	@Override
	public Contestant storeContestant(Contestant t) {
		if (t.getId() == 0) {
			t.setId(contestantId.incrementAndGet());
		}
		contestants.put(t.getId(), t);
		return t;
	}


	@Override
	public LevelTimer storeLevelTimer(LevelTimer l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContestState getContestState(long contestId) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public Contestant getContestant(long contestantId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
