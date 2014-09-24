package com.quiz.service;



import com.quiz.entities.Contestant;
import com.quiz.entities.QuizSolution;
import com.quiz.entities.User;
import com.quiz.web.model.ContestInfo;
import com.quiz.web.model.Result;
import com.quiz.web.model.ScheduleContestResult;
import java.util.List;


public interface IContestService {

	void submitResults(QuizSolution quizSolution, long contestId);

	boolean isGameFinished(long contestId);

	ScheduleContestResult scheduleContest(ContestInfo contestInfo);

	ScheduleContestResult updateContest(ContestInfo contestInfo);

	boolean deleteContest(long contestId);

	boolean isRegistered(long contestId);

	Result joinContest(long contestId);

	Contestant getContestantInfo(long contestId);

	List<Contestant> getContestants(long contestId);

        public User getUser();

}
