package com.quiz;

import com.quiz.dao.IContestDao;
import com.quiz.dao.IQuizDao;
import com.quiz.dao.impl.QuizDao;
import com.quiz.entities.QuizContest;
import com.quiz.entities.ScheduledContest;
import com.quiz.entities.TrainingContest;
import com.quiz.entities.User;
import com.quiz.service.IContestService;
import com.quiz.service.impl.AuthenticationContext;
import com.quiz.service.impl.ContestService;
import com.quiz.shared.entities.ContestState;
import com.quiz.shared.entities.Result;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContestServiceTest {

    private IContestService contestApi;

    @Before
    public void setup() throws IOException {
        IQuizDao gameDao = new QuizDao();
        IContestDao contestDao = new MockContestDao();
        QuizContest contest = new TrainingContest();
        contest.setId(1);
        contestDao.storeContest(contest);
        contestApi = new ContestService(contestDao, gameDao);
        User user = new User();
        user.setUserName("testuser");

        AuthenticationContext.user=user;
    }

    @Test
    public void joinContest() {
        System.out.println(AuthenticationContext.getCurrentUser());
        Assert.assertEquals(Result.Success, contestApi.joinContest(1));
    }

    @Test
    public void submitResults() {
        contestApi.joinContest(1);
        Map<String, String> results = new HashMap<String, String>();
//		contestApi.selectLevel(1, 1);
        contestApi.submitResults(results, 1);
    }

}