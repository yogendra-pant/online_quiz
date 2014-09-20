package com.quiz.service.impl;

import com.quiz.dao.IContestDao;
import com.quiz.dao.IQuizDao;
import com.quiz.entities.Contestant;
import com.quiz.entities.LevelTimer;
import com.quiz.entities.Quiz;
import com.quiz.entities.QuizContest;
import com.quiz.entities.ScheduledContest;

import com.quiz.entities.TrainingContest;

import com.quiz.entities.User;
import com.quiz.service.IContestService;
import com.quiz.shared.entities.ContestInfo;
import com.quiz.shared.entities.ContestState;
import com.quiz.shared.entities.LevelInfo;
import com.quiz.shared.entities.LevelTime;
import com.quiz.shared.entities.Result;
import com.quiz.shared.entities.ScheduleContestResult;
import com.quiz.shared.entities.UserTime;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ContestService implements IContestService {

    private final IContestDao contestDao;
    private final IQuizDao gameDao;

    public ContestService(IContestDao contestDao, IQuizDao gameDao) {
        this.contestDao = contestDao;
        this.gameDao = gameDao;
    }

    @Override
    public double getDuration(long contestId) {
        Contestant contestant = getContestant(contestId);

        if (contestant.isPaused()) {
            return contestant.getDuration() / 1000;
        }

        if (contestant.isFinished()) {
            return contestant.getDuration() / 1000;
        }

        long diff = contestant.getDuration() + System.currentTimeMillis() - contestant.getStartTime();

        return diff / 1000;
    }


    @Override
    public LevelInfo getLevelInfo(long contestId) {
        QuizContest contest = contestDao.getContest(contestId);
        if (contest == null) {
//			logger.error("Invalid Contest {}", contestId);
        }

        Contestant contestant = getContestant(contestId);
        if (contestant == null) {
//			logger.error("Invalid contestant for contest {}, for user {}", contestId, AuthenticationContext.getCurrentUser().getId());
        }
        Quiz game = gameDao.getQuiz(contest.getQuiz().getId());
       

        if (game == null) {
//			logger.error("No game found with name {}", contestId, contest.getGameName());
        }
        return new LevelInfo(game.getNrOfQuestions(), contestant.getCurrentLevel(), contestant.getSelectedLevel(),
                contestant.isFinished());
    }

    @Override
    public List<LevelTime> getLevelTimes(long contestId) {
        Contestant contesTant = getContestant(contestId);
        List<LevelTimer> levelTimers = contestDao.getLevelTime(contesTant.getId());
        List<LevelTime> levelTimes = new ArrayList<LevelTime>();
        for (LevelTimer levelTimer : levelTimers) {
            LevelTime levelTime = new LevelTime();
            levelTime.setLevel(levelTimer.getLevel());
            levelTime.setDuration(levelTimer.getDuration());
            levelTimes.add(levelTime);
        }
        return levelTimes;
    }


    @Override
    public boolean isRegistered(long contestId) {
        Contestant c = getContestant(contestId);
        return c != null;
    }

    @Override
    public Result joinContest(long contestId) {
        QuizContest c = contestDao.getContest(contestId);
        if (c == null) {
            return Result.Failure;
        }
        if (!isRegistered(contestId)) {
            Contestant ct = new Contestant();
            ct.setContest(c);
			ct.setUser((User) AuthenticationContext.getCurrentUser());
            if (ct.getUser() == null) {
                return Result.Failure;
            }
            if (c instanceof ScheduledContest) {
                ScheduledContest contest = (ScheduledContest) c;
                ct.setStartTime(contest.getStartTime().getTime());

            }
            contestDao.storeContestant(ct);
            c.getContestants().add(ct);
            contestDao.storeContest(c);
            return Result.Success;
        }

        return Result.Success;
    }

    @Override
    public ScheduleContestResult scheduleContest(ContestInfo contestInfo) {
        if (contestInfo.getStartTime().getTime() < (System.currentTimeMillis())) {
            return ScheduleContestResult.StartDateInvalid;
        }

        ScheduledContest s = new ScheduledContest();
//        s.setGameName(contestInfo.getGameName());
        s.setName(contestInfo.getContestName());

        long date = contestInfo.getStartTime().getTime();
        s.setStartTime(new Date(date));

        s.setDurationHours(contestInfo.getDurationHours());
        s.setDurationMinutes(contestInfo.getDurationMinutes());
        s.setContestState(ContestState.OPEN_FOR_REGISTRATION);
        s.setOrganizer(contestInfo.getOrganizer());
        s.setOrganizerEmail(contestInfo.getOrgainzerEmail());

        contestDao.storeContest(s);

        return ScheduleContestResult.Success;
    }

    @Override
    public boolean deleteContest(ContestInfo contestInfo) {
        QuizContest c = contestDao.getContest(contestInfo.getContestId());
        contestDao.deleteContest(c);
        return true;
    }

    private void logContestInfo(String text, Contestant t, Object... args) {
//		contestLogger
//				.info("{}: User {} " + text, ArrayUtils.addAll(new Object[] { t.getContest().getName(), t.getUser().getName() }, args));
    }

    @Override
    public Map<String, String> submitResults(Map<String, String> results, long contestId) {
//        boolean invalidTest = false;
//        Contestant t = getContestant(contestId);
//        QuizContest contest = contestDao.getContest(contestId);
//        List<Test> tests = getTestCases(contestId);
//
//        if (tests.size() == 0) {
//            return new HashMap<String, String>();
//        }
//
//        Map<String, String> r = new HashMap<String, String>();
//
//        int failedCounter = 0;
//
//        String completedLevelTestsIndicator;
//        String currentCompletedLevelTestsStatus = t.getCompletedLevelTestsIndicator();
//
//        StringBuffer testSummary = new StringBuffer();
//        completedLevelTestsIndicator = "";
//        int index = 0;
//        //todo remember passed tests
//        for (Test test : tests) {
//            testSummary.append("   " + test.getData() + " (" + test.getName() + "): " + results.get(test.getData()));
//            testSummary.append("\n         --> ");
//
//            if (currentCompletedLevelTestsStatus != null && !"".equals(currentCompletedLevelTestsStatus)) {
//                if (currentCompletedLevelTestsStatus.charAt(index) == 'Y') {
//                    r.put(test.getData(), Result.Success.name());
//                    completedLevelTestsIndicator += "Y";
//                    index++;
//                    continue;
//
//                }
//            }
//            if (results.containsKey(test.getData()) && test.getSolutions().contains(trim(results.get(test.getData())))) {
//                r.put(test.getData(), Result.Success.name());
//                completedLevelTestsIndicator += "Y";
//                testSummary.append("OK");
//            } else if (results.get(test.getData()) != null && results.get(test.getData()).equals("")) {
//                r.put(test.getData(), Result.Invalid.name());
//                completedLevelTestsIndicator += "N";
//                testSummary.append("INVALID");
//                invalidTest = true;
//            } else {
//                r.put(test.getData(), Result.Failure.name());
//                completedLevelTestsIndicator += "N";
//                testSummary.append("ERROR");
//                failedCounter++;
//            }
//            testSummary.append("\n");
//            index++;
//        }
//        t.setCompletedLevelTestsIndicator(completedLevelTestsIndicator);
//        logContestInfo("submits solution for level {}:\n{}     -- {} failure(s)", t, t.getCurrentLevel(), testSummary, failedCounter);
//
//        if (failedCounter == 0 && !invalidTest) {
//            t.setCompletedLevelTestsIndicator("");
//            Quiz game = gameDao.getGame(contest.getGameName());
//
//            LevelTimer l = new LevelTimer();
//            l.setLevel(t.getCurrentLevel());
//            l.setDuration((long) (getDuration(contestId)));
//            l.setContestant(t);
////			l.setLevelTestFails(t.getFailedConter());
//
//            l = contestDao.storeLevelTimer(l);
////			t.getLevelTimers().add(l);
//
//            if (t.getCurrentLevel() < game.getGameInfo().getNrOfLevels()) {
//                t.setCurrentLevel(t.getCurrentLevel() + 1);
//                logContestInfo("reaches level {}", t, t.getCurrentLevel());
//            } else {
//                t.setDuration((long) (getDuration(contestId) * 1000));
//                Date now = new Date();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                String ss = sdf.format(now);
//                t.setFinishedDate(ss);
//                t.setFinished(true);
//                logContestInfo("finishes the contest in {}", t, t.getDuration());
//            }
//        } else {
////			t.setFailedConter(t.getFailedConter() + failedCounter);
//        }

//        contestDao.storeContestant(t);
        return null;
    }

    private String trim(String string) {
        if (string == null) {
            return null;
        }
        return string.trim();
    }

    private Contestant getContestant(long contestId) {
        User user = AuthenticationContext.getCurrentUser();
        if (user == null) {
            return null;
        }
        return contestDao.getContestant(contestId, user.getId());

    }

    @Override
    public boolean isGameFinished(long contestId) {
        Contestant contestant = getContestant(contestId);
        return contestant.isFinished();
    }

    @Override
    public Contestant getContestantInfo(long contestId) {
        User user = AuthenticationContext.getCurrentUser();
        return contestDao.getContestant(contestId, user.getId());

    }

    @Override
    public List<Contestant> getContestants(long contestId) {
        return contestDao.getContestants(contestId);
    }


    @Override
    public ScheduleContestResult updateContest(ContestInfo contestInfo) {
        if (contestInfo.getStartTime().getTime() < (System.currentTimeMillis())) {
            return ScheduleContestResult.StartDateInvalid;
        }
        ScheduledContest s = (ScheduledContest) contestDao.getContest(contestInfo.getContestId());

        s.setStartTime(contestInfo.getStartTime());
        s.setDurationHours(contestInfo.getDurationHours());
        s.setDurationMinutes(contestInfo.getDurationMinutes());

        contestDao.storeContest(s);

        return ScheduleContestResult.Success;
    }

    @Override
    public UserTime getUserTime(long contestId) {
        Contestant contestant = getContestant(contestId);
        return new UserTime(getDuration(contestId), contestant.isPaused());
    }

 

    @Override
    public int getNumberOfLevels(long contestId) {
        QuizContest contest = contestDao.getContest(contestId);
        Quiz game = gameDao.getQuiz(contest.getQuiz().getId());
        return game.getNrOfQuestions();
    }

    @Override
    public String getContestantCompletedLevelTestsStatus(long contestId) {
        Contestant t = getContestant(contestId);
        return t.getCompletedLevelTestsIndicator();
    }

}
