package com.quiz.service.impl;

import com.quiz.dao.IContestDao;
import com.quiz.entities.Contestant;
import com.quiz.entities.ScheduledContest;
import com.quiz.service.IContestStateService;
import com.quiz.shared.entities.ContestState;
import java.util.Date;
import java.util.List;



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

			System.out.println(contest.getDurationHours());
			System.out.println(contest.getDurationMinutes());

			long endTime = contest.getStartTime().getTime() + ((contest.getDurationHours() * 60 + contest.getDurationMinutes()) * 60000);
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
			long endTime = contest.getStartTime().getTime() + ((contest.getDurationHours() * 60 + contest.getDurationMinutes()) * 60000);

			if (endTime < now.getTime()) {
				contest.setContestState(ContestState.COMPLETED);
				contestDao.storeContest(contest);
			}

		}

	}
}
