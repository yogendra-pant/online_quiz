package com.quiz.service;


import com.quiz.entities.Contestant;
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

	Map<String, String> submitResults(Map<String, String> results, long contestId);

	boolean isGameFinished(long contestId);

	LevelInfo getLevelInfo(long contestId);

	ScheduleContestResult scheduleContest(ContestInfo contestInfo);

	ScheduleContestResult updateContest(ContestInfo contestInfo);

	boolean deleteContest(ContestInfo contestInfo);

	List<LevelTime> getLevelTimes(long contestId);

	double getDuration(long contestId);

	boolean isRegistered(long contestId);

	Result joinContest(long contestId);

	Contestant getContestantInfo(long contestId);

	List<Contestant> getContestants(long contestId);

	UserTime getUserTime(long contestId);

	int getNumberOfLevels(long contestId);

	String getContestantCompletedLevelTestsStatus(long contestId);

}
