package com.quiz.service;

import com.quiz.entities.Contestant;
import com.quiz.entities.Quiz;
import com.quiz.shared.entities.ContestInfo;
import com.quiz.shared.entities.ContestResult;
import com.quiz.shared.entities.ContestState;
import com.quiz.shared.entities.TrainingInfo;
import java.util.List;



public interface IQuizService {
        void storeQuiz(Quiz quiz);

	List<Quiz> getAvailableGames();

	List<Contestant> getContestants(long contestId);

	ContestInfo getContestInfo(long contestId);

	double getRemainingTimeToStart(long contestId);

	double getRemainingTimeToEnd(long contestId);

	List<ContestResult> getStatistics(long contestId);

	List<TrainingInfo> getTrainingContests();

	List<ContestInfo> getScheduledContests(ContestState state);

	ContestState getContestState(long contestId);

}
