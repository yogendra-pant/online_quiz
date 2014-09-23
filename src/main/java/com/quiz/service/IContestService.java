package com.quiz.service;



import com.quiz.entities.Contestant;
import com.quiz.entities.Quiz;
import com.quiz.entities.QuizSolution;
import com.quiz.entities.ScheduledContest;
import com.quiz.entities.User;
import com.quiz.shared.entities.ContestInfo;
import com.quiz.shared.entities.LevelInfo;
import com.quiz.shared.entities.LevelTime;
import com.quiz.shared.entities.Result;
import com.quiz.shared.entities.ScheduleContestResult;
import com.quiz.shared.entities.UserTime;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.Resource;


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
