package com.quiz.service;

import com.quiz.entities.Contestant;
import com.quiz.entities.QuizSolution;
import com.quiz.entities.User;
import com.quiz.web.model.ContestInfo;
import com.quiz.web.model.Result;

import java.util.List;

public interface IContestService {

    public void submitSolutions(QuizSolution quizSolution, long contestId);

    public void scheduleQuizContest(ContestInfo contestInfo);

    public void updateQuizContest(ContestInfo contestInfo);

    public boolean deleteContest(long contestId);

    public boolean isRegistered(long contestId);

    public Result joinContest(long contestId);

    public Contestant getContestantInfo(long contestId);

    public List<Contestant> getContestants(long contestId);

    public User getUser();

}
