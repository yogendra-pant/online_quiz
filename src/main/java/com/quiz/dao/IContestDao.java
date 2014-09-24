package com.quiz.dao;

import com.quiz.entities.QuizContest;
import com.quiz.entities.Contestant;
import com.quiz.entities.ScheduledContest;
import com.quiz.entities.TrainingContest;
import com.quiz.web.model.ContestState;
import java.util.List;


public interface IContestDao {
	QuizContest storeContest(QuizContest contest);

	boolean deleteContest(QuizContest contest);

	List<TrainingContest> getTrainingContests();

	List<ScheduledContest> getScheduledContests();

	List<ScheduledContest> getScheduledContestsByState(ContestState state);

	Contestant storeContestant(Contestant t);

	Contestant getContestant(long contestId, long userId);
        Contestant getContestant(long contestantId);

	QuizContest getContest(long contestId);

	List<Contestant> getContestants(long contestId);

	TrainingContest getTrainingContestByGame(String gameName);

	TrainingContest getTrainingContestById(long contestId);

	ContestState getContestState(long contestId);

}
