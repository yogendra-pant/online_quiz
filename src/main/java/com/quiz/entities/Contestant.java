package com.quiz.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.ForeignKey;



@Entity
public class Contestant extends EntityObject {

	private static final long serialVersionUID = 1L;

	private QuizContest contest;

	private User user;

	private int currentLevel = 1;

	private int selectedLevel;

	private long duration;

	private boolean paused;

	private long startTime;

	private boolean finished;

	private String finishedDate;

	private String completedLevelTestsIndicator;

        public Contestant(){
            
        }
	public void setContest(QuizContest contest) {
		this.contest = contest;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "FK_CONTEST_TO_CONTESTANT")
	public QuizContest getContest() {
		return contest;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setSelectedLevel(int selectedLevel) {
		this.selectedLevel = selectedLevel;
	}

	public int getSelectedLevel() {
		return selectedLevel;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getDuration() {
		return duration;
	}

	public void setPaused(boolean isPaused) {
		this.paused = isPaused;
	}

	public boolean isPaused() {
		return paused;
	}

	public void setFinishedDate(String finishedDate) {
		this.finishedDate = finishedDate;
	}

	public String getFinishedDate() {
		return finishedDate;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "FK_USER_TO_CONTESTANT")
	public User getUser() {
		return user;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public boolean isFinished() {
		return finished;
	}

	@Transient
	public String getEmailId() {
//		return user.getEmailAddress();
            return "";
	}

	@Transient
	public int getCompletedLevel() {

		if (selectedLevel < currentLevel)
			return selectedLevel;
		else if (selectedLevel == currentLevel && !finished)
			return selectedLevel - 1;
		else
			return selectedLevel;

	}

	public void setCompletedLevelTestsIndicator(String completedLevelTestsIndicator) {
		this.completedLevelTestsIndicator = completedLevelTestsIndicator;
	}

	public String getCompletedLevelTestsIndicator() {
		return completedLevelTestsIndicator;
	}

}
