package com.quiz;

import com.quiz.entities.Contestant;
import com.quiz.entities.ScheduledContest;
import com.quiz.entities.User;
import com.quiz.service.IContestService;
import com.quiz.service.IContestStateService;
import com.quiz.service.impl.ContestService;
import com.quiz.service.impl.ContestStateService;
import com.quiz.shared.entities.ContestInfo;
import com.quiz.shared.entities.ContestState;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ContestStateServiceTest extends QuizTestCase {

    private IContestStateService contestStateApi;

    private IContestService contestApi;

    private User user;

    public ContestStateServiceTest() {
        System.setProperty("games.root.dir", "file:/test/data");
    }

    @Before
    public void before() {
        contestStateApi = new ContestStateService(contestDao);
        contestApi = new ContestService(contestDao, quizDao);
        user = new User();
        user.setUserName("puneet");
        user.setEmailId("puneetkhanal@gmail.com");
        user.setPhoneNumber("9841684566");
        user.setPassword("hello");

        userDao.add(user);
    }

    @Test
    public void processContest() {
        ContestInfo contestInfo = new ContestInfo();
        contestInfo.setContestName("xxxx");
//        contestInfo.setDurationHours(1);
//        contestInfo.setDurationMinutes(1);
        contestInfo.setContestDate(new Date());
//        contestInfo.setGameName("bowling");

        contestApi.scheduleContest(contestInfo);

        List<ScheduledContest> contests = contestDao.getScheduledContests();
        Assert.assertEquals(1, contests.size());
        ScheduledContest c = contests.get(0);

        Contestant ct = new Contestant();
        ct.setContest(c);
        ct.setUser(user);
        ct = contestDao.storeContestant(ct);

        c.getContestants().add(ct);
        c = (ScheduledContest) contestDao.storeContest(c);

        contestStateApi.processScheduledContests();

        contests = contestDao.getScheduledContests();
        Assert.assertEquals(1, contests.size());
        c = contests.get(0);
        Assert.assertEquals(ContestState.RUNNING, c.getContestState());

        ct = contestDao.getContestant(c.getId(), user.getId());
        Assert.assertNotNull(ct);

        Assert.assertEquals(c.getStartTime().getTime(), ct.getStartTime());

    }
}
