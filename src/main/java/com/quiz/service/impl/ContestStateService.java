package com.quiz.service.impl;

import com.quiz.dao.IContestDao;
import com.quiz.entities.Contestant;
import com.quiz.entities.ScheduledContest;
import com.quiz.service.IContestStateService;
import com.quiz.shared.entities.ContestState;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation = Propagation.REQUIRES_NEW)
public class ContestStateService implements IContestStateService {

	private final IContestDao contestDao;

	public ContestStateService(IContestDao contestDao) {
		this.contestDao = contestDao;
	}

	@Override
	public void processScheduledContests() {
		List<ScheduledContest> openContests = contestDao.getScheduledContestsByState(ContestState.OPEN_FOR_REGISTRATION);
		Date now = new Date();

		for (ScheduledContest contest : openContests) {

			System.out.println(contest.getDuration().getHours());
			System.out.println(contest.getDuration().getMinutes());

			long endTime = contest.getStartTime().getTime() + ((contest.getDuration().getHours() * 60 + contest.getDuration().getMinutes()) * 60000);
			long startTime = contest.getStartTime().getTime();
			long currentTime = now.getTime();

			System.out.println(endTime);
			System.out.println(startTime);
			System.out.println(currentTime);

			if ((startTime <= currentTime) && (currentTime < endTime)) {
				contest.setContestState(ContestState.RUNNING);
				contestDao.storeContest(contest);

				List<Contestant> contestants = contestDao.getContestants(contest.getId());

				for (Contestant contestTant : contestants) {
					contestTant.setStartTime(startTime);
					contestDao.storeContestant(contestTant);
				}

			} else if (currentTime >= endTime) {
				contest.setContestState(ContestState.CANCELED);
				contestDao.storeContest(contest);

			}

		}

		List<ScheduledContest> runningContest = contestDao.getScheduledContestsByState(ContestState.RUNNING);

		for (ScheduledContest contest : runningContest) {
			long endTime = contest.getStartTime().getTime() + ((contest.getDuration().getHours() * 60 + contest.getDuration().getMinutes()) * 60000);

			if (endTime < now.getTime()) {
				contest.setContestState(ContestState.COMPLETED);
				contestDao.storeContest(contest);
			}

		}

	}
}
