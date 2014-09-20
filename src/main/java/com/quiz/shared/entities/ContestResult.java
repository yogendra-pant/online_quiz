package com.quiz.shared.entities;

import java.util.List;



public class ContestResult implements Comparable<ContestResult> {

	private int rank;

	private String name;

	private double completedTime;

	private int testsFailed;

	private int completedLevel;

	private List<LevelTime> userLevelTimes;

	private boolean sourcecode;

	private boolean finished;

	private boolean contestFinished;
	private String codingLanguage;

	private String finishedDate;

	private String emailId;

	public void setSourceCode(boolean state) {
		this.sourcecode = state;
	}

	public boolean getSourceCode() {
		return sourcecode;
	}

	public void setFinished(boolean state) {
		this.finished = state;
	}

	public boolean getFinished() {
		return finished;
	}

	public void setContestFinished(boolean state) {
		this.contestFinished = state;
	}

	public boolean getContestFinished() {
		return contestFinished;
	}

	public void setCodingLanguage(String codingLanguage) {
		this.codingLanguage = codingLanguage;
	}

	public String getCodingLangauage() {
		return codingLanguage;
	}

	public void setFinishedDate(String finishedDate) {
		this.finishedDate = finishedDate;

	}

	public String getFinishedDate() {
		return finishedDate;
	}

	public ContestResult() {

	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCompletedTime(double completedTime) {
		this.completedTime = completedTime;
	}

	public double getCompletedTime() {
		return completedTime;
	}

	public void setTestsFailed(int testsFailed) {
		this.testsFailed = testsFailed;
	}

	public int getTestsFailed() {
		return testsFailed;
	}

	public void setCompletedLevel(int completedLevel) {
		this.completedLevel = completedLevel;
	}

	public int getCompletedLevel() {
		return completedLevel;
	}

	public void setUserLevelTimes(List<LevelTime> userLevelTimes) {
		this.userLevelTimes = userLevelTimes;
	}

	public List<LevelTime> getUserLevelTimes() {
		return userLevelTimes;
	}

	@Override
	public int compareTo(ContestResult other) {
		if (getCompletedLevel() > other.getCompletedLevel()) {
			return 1;
		}
		if (getCompletedLevel() < other.getCompletedLevel()) {
			return -1;
		}

		if (completedTime < other.getCompletedTime()) {
			return 1;
		}

		if (completedTime > other.getCompletedTime()) {
			return -1;
		}

		if (testsFailed < other.getTestsFailed()) {
			return 1;
		}
		if (testsFailed < other.getTestsFailed()) {
			return -1;
		}

		return other.getName().compareTo(other.getName());
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}
}
