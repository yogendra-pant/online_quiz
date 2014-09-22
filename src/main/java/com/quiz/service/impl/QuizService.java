package com.quiz.service.impl;

import com.quiz.dao.IContestDao;
import com.quiz.dao.IQuizDao;
import com.quiz.entities.QuizContest;
import com.quiz.entities.Contestant;
import com.quiz.entities.Quiz;
import com.quiz.entities.LevelTimer;
import com.quiz.entities.ScheduledContest;
import com.quiz.entities.TrainingContest;
import com.quiz.entities.Visibility;
import com.quiz.service.IQuizService;
import com.quiz.shared.entities.ContestInfo;
import com.quiz.shared.entities.ContestResult;
import com.quiz.shared.entities.ContestState;
import com.quiz.shared.entities.LevelTime;
import com.quiz.shared.entities.TrainingInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public class QuizService implements IQuizService {

    private final IQuizDao gameDao;

    private final IContestDao contestDao;
//	private final Logger logger = LoggerFactory.getLogger(QuizService.class);

    public QuizService(IQuizDao gameDao, IContestDao contestDao) {
        this.gameDao = gameDao;
        this.contestDao = contestDao;
    }

    @Override
    public List<Quiz> getAvailableGames() {
        return gameDao.getAvailableQuiz(Visibility.Public);
    }

    @Override
    public List<ContestInfo> getScheduledContests(ContestState state) {
        List<ScheduledContest> contests = contestDao.getScheduledContestsByState(state);
        List<ContestInfo> contestInfos = new ArrayList<ContestInfo>();
        for (ScheduledContest contest : contests) {
            contestInfos.add(convertToContestInfo(contest));
        }
        return contestInfos;

    }

    @Override
    public List<Contestant> getContestants(long contestId) {
        return contestDao.getContestants(contestId);
    }

    @Override
    public ContestInfo getContestInfo(long contestId) {
        QuizContest c = contestDao.getContest(contestId);
        if (c instanceof ScheduledContest) {
            ScheduledContest contest = (ScheduledContest) c;
            return convertToContestInfo(contest);

        } else {
            TrainingContest contest = (TrainingContest) c;
            ContestInfo info = new ContestInfo();
            info.setContestId(contest.getId());
            info.setContestName(contest.getName());
//            info.setGameName(contest.getGame().getGameInfo().getName());
            return info;
        }
    }

    private ContestInfo convertToContestInfo(ScheduledContest contest) {
        ContestInfo info = new ContestInfo();
        info.setContestId(contest.getId());
        info.setContestName(contest.getName());
//		info.setGameName(contest.getGameName());
//        info.setState(contest.getContestState());
//        info.setOrganizer(contest.getOrganizer());
        info.setOrganizerEmail(contest.getOrganizerEmail());
        info.setContestDate(contest.getStartTime());
//        info.setDurationHours(contest.getDurationHours());
//        info.setDurationMinutes(contest.getDurationMinutes());
        return info;
    }

    @Override
    public double getRemainingTimeToStart(long contestId) {
        QuizContest c = contestDao.getContest(contestId);
        if (c != null && c instanceof ScheduledContest) {
            ScheduledContest sc = (ScheduledContest) c;
            Date st = sc.getStartTime();
            return (st.getTime() - System.currentTimeMillis()) / 1000;
        }
        return 0;
    }

    @Override
    public double getRemainingTimeToEnd(long contestId) {
        QuizContest c = contestDao.getContest(contestId);
        if (c != null && c instanceof ScheduledContest) {
            ScheduledContest sc = (ScheduledContest) c;
            long time = sc.getStartTime().getTime() + ((sc.getDuration().getHours() * 60 + sc.getDuration().getMinutes()) * 60000);
            return ((time - System.currentTimeMillis()) / 1000);
        }
        return 0;
    }

    @Override
    public List<ContestResult> getStatistics(long contestId) {
        List<Contestant> contestants = getContestants(contestId);
        QuizContest c = contestDao.getContest(contestId);

        List<ContestResult> coders = new ArrayList<ContestResult>();
        for (Contestant contestTant : contestants) {
            long contestantId = contestTant.getId();

            ContestResult result = new ContestResult();

            if (contestTant.isFinished()) {
                result.setCompletedTime(contestTant.getDuration() / 1000);
            }

            List<LevelTimer> levelTimers = contestDao.getLevelTime(contestantId);
            List<LevelTime> levelTimes = new ArrayList<LevelTime>();
          
            for (LevelTimer levelTimer : levelTimers) {
                LevelTime levelTime = new LevelTime();
              

                levelTime.setLevel(levelTimer.getLevel());
                levelTime.setDuration(levelTimer.getDuration());

              
                levelTimes.add(levelTime);
            }
            if (c != null && c instanceof ScheduledContest) {
                ScheduledContest sc = (ScheduledContest) c;
                ContestState state = sc.getContestState();
                if (state == ContestState.COMPLETED) {
                    result.setContestFinished(true);
                }
            }

            if (levelTimers.size() > 0) {
                result.setCompletedTime(levelTimers.get(levelTimers.size() - 1).getDuration());
            } else {
                result.setCompletedTime(0);
            }
            result.setUserLevelTimes(levelTimes);
            result.setName(contestTant.getUser().getUserName());
//			result.setTestsFailed(contestTant.getFailedConter());
            result.setCompletedLevel(contestTant.isFinished() ? contestTant.getCurrentLevel() : (contestTant.getCurrentLevel() - 1));
//			result.setSourceCode(contestTant.getSourceCode());
            result.setFinishedDate(contestTant.getFinishedDate());
            result.setFinished(contestTant.isFinished());
//			result.setCodingLanguage(contestTant.getCodingLanguage());
            result.setEmailId(contestTant.getEmailId());
            coders.add(result);

        }
        return coders;
    }

    @Override
    public List<TrainingInfo> getTrainingContests() {
        List<TrainingContest> contests = contestDao.getTrainingContests();
        List<TrainingInfo> trainingInfos = new ArrayList<TrainingInfo>();
        for (TrainingContest trainingContest : contests) {

            if (trainingContest.getQuiz() == null) {
//				logger.error("Could not find GameInfo for " + trainingContest.getGameName());
            } else {
                TrainingInfo info = new TrainingInfo();
                info.setContestId(trainingContest.getId());
                info.setContestName(trainingContest.getQuiz().getName());
                info.setDescription(trainingContest.getQuiz().getDescription());
//				info.setSeverity(gameInfo.getSeverity());
//				info.setNrOfLevels(gameInfo.getNrOfLevels());
                trainingInfos.add(info);
            }
        }
        return trainingInfos;
    }

    public TrainingInfo getTrainingContestById(long contestId) {
        TrainingContest contests = contestDao.getTrainingContestById(contestId);
//        TrainingInfo info = new TrainingInfo(contests.getGame().getGameInfo());
         TrainingInfo info=null ;
        return info;
    }

    @Override
    public ContestState getContestState(long contestId) {
        return contestDao.getContestState(contestId);
    }     
    
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void storeQuiz(Quiz quiz){
        gameDao.storeQuiz(quiz);
        
    }

}
