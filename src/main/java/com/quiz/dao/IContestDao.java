package com.quiz.dao;

import com.quiz.entities.QuizContest;
import com.quiz.entities.Contestant;
import com.quiz.entities.ScheduledContest;
import java.util.List;

public interface IContestDao {

    public QuizContest storeContest(QuizContest contest);

    public boolean deleteContest(QuizContest contest);

    public List<ScheduledContest> getScheduledContests();

    public Contestant storeContestant(Contestant t);

    public Contestant getContestant(long contestId, long userId);

    public Contestant getContestant(long contestantId);

    public QuizContest getContest(long contestId);

    public List<Contestant> getContestants(long contestId);

}
