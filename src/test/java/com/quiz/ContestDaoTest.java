package com.quiz;



import com.quiz.entities.Contestant;
import com.quiz.entities.LevelTimer;
import com.quiz.entities.ScheduledContest;
import com.quiz.entities.TrainingContest;
import com.quiz.entities.User;
import com.quiz.shared.entities.ContestState;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
@TransactionConfiguration
@Transactional
public class ContestDaoTest extends QuizTestCase {

    public ContestDaoTest() {

    }

    @Test
    public void storeContest() {
        TrainingContest t = new TrainingContest();
        t.setName("ea");

        t = (TrainingContest) contestDao.storeContest(t);

        Assert.assertNotNull(t);

    }

    @Test
    public void getTrainingContests() {
        TrainingContest t = new TrainingContest();
        t.setName("ea");

        t = (TrainingContest) contestDao.storeContest(t);

        Assert.assertNotNull(t);

        List<TrainingContest> contests = contestDao.getTrainingContests();

        Assert.assertEquals(1, contests.size());

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
    public void getScheduledContestByState() {
        ScheduledContest c = new ScheduledContest();
        c.setName("ea");
        c.setContestState(ContestState.OPEN_FOR_REGISTRATION);

        contestDao.storeContest(c);

        List<ScheduledContest> contests = contestDao.getScheduledContestsByState(ContestState.OPEN_FOR_REGISTRATION);
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

    public void getTimers() {
        ScheduledContest c = new ScheduledContest();
        c.setName("ea");
        c.setContestState(ContestState.OPEN_FOR_REGISTRATION);

        c = (ScheduledContest) contestDao.storeContest(c);

        User user = new User();
        user.setUserName("dev");
        userDao.add(user);

        Contestant t = new Contestant();
//        t.setContest(c);
//        t.setUser(user);

        t = contestDao.storeContestant(t);

        c.getContestants().add(t);

        c = (ScheduledContest) contestDao.storeContest(c);

        LevelTimer lt = new LevelTimer();
        lt.setContestant(t);
        lt.setDuration(60000);
        lt.setLevel(1);

        lt = contestDao.storeLevelTimer(lt);

        List<LevelTimer> levelTimers = contestDao.getLevelTime(t.getId());

        Assert.assertEquals(1, levelTimers.size());

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

    @Test
    public void getContestState() {
        ScheduledContest c = new ScheduledContest();
        c.setName("ea");
        c.setContestState(ContestState.OPEN_FOR_REGISTRATION);

        c = (ScheduledContest) contestDao.storeContest(c);

        ContestState s = contestDao.getContestState(c.getId());

        Assert.assertEquals(ContestState.OPEN_FOR_REGISTRATION, s);

    }

}
