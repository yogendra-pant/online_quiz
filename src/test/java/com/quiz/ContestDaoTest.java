package com.quiz;

import com.quiz.entities.Contestant;
import com.quiz.entities.ScheduledContest;
import com.quiz.entities.User;
import com.quiz.web.model.ContestState;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ContestDaoTest extends QuizTestCase {

    public ContestDaoTest() {

    }

    @Test
    public void getScheduledContests() {
        ScheduledContest c = new ScheduledContest();
        c.setName("ea");

        contestDao.storeContest(c);

        List<ScheduledContest> contests = contestDao.getScheduledContests();
        Assert.assertEquals(1, contests.size());

    }


    @Test
    public void getContest() {

        ScheduledContest c = new ScheduledContest();
        c.setName("ea");
        c.setContestState(ContestState.OPEN_FOR_REGISTRATION);

        c = (ScheduledContest) contestDao.storeContest(c);

        ScheduledContest sc = (ScheduledContest) contestDao.getContest(c.getId());

        Assert.assertNotNull(sc);

    }

    @Test
    public void addContestant() {
        ScheduledContest c = new ScheduledContest();
        c.setName("ea");
        c.setContestState(ContestState.OPEN_FOR_REGISTRATION);

        contestDao.storeContest(c);

        User user = new User();
        user.setUserName("puneet");
        user.setEmailId("puneetkhanal@gmail.com");
        user.setPhoneNumber("9841684566");
        user.setPassword("hello");
        userDao.add(user);

        Contestant t = new Contestant();
        t.setContest(c);
        t.setUser(user);

        contestDao.storeContestant(t);

        c.getContestants().add(t);

//        contestDao.storeContest(c);
        Assert.assertEquals(1, c.getContestants().size());

        System.out.println(c.getId() + ":" + user.getId());
        Contestant ct = contestDao.getContestant(c.getId(), user.getId());
        Assert.assertNotNull(ct);

    }

    @Test
    public void getContestant() {

    }

    @Test
    public void removeContest() {
        ScheduledContest c = new ScheduledContest();
        c.setName("ea");
        c.setContestState(ContestState.OPEN_FOR_REGISTRATION);

        c = (ScheduledContest) contestDao.storeContest(c);

        ScheduledContest sc = (ScheduledContest) contestDao.getContest(c.getId());
        Assert.assertNotNull(sc);

        contestDao.deleteContest(sc);
        sc = (ScheduledContest) contestDao.getContest(c.getId());
        Assert.assertNull(sc);

    }

   

}
