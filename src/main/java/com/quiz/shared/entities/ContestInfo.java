package com.quiz.shared.entities;

import java.util.Date;


public class ContestInfo {
	/**
   *
   */

	public ContestInfo() {

	}

	private static final long serialVersionUID = -367693634233483706L;

	private String contestName;

	private String organizer;

	private Date startTime;

	private int durationHours;

	private int durationMinutes;

	private String gameName;

	private ContestState state;

	private String organizerEmail;

	private long contestId;

	public ContestInfo(String contestName, String organizer, Date startTime, int durationHours, int durationMinutes, String gameName,
			ContestState state) {
		this.setContestName(contestName);
		this.setOrganizer(organizer);
		this.setStartTime(startTime);
		this.setDurationHours(durationHours);
		this.setDurationMinutes(durationMinutes);
		this.gameName = gameName;
		this.state = state;
	}

	public int getDurationHours() {
		return durationHours;
	}

	public ContestInfo(String contestName, String organizer, String organizerEmail, Date startTime, int durationHours, int durationMinutes,
			String gameName, ContestState state) {
		this(contestName, organizer, startTime, durationHours, durationMinutes, gameName, state);
		this.setOrganizerEmail(organizerEmail);
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public String getName() {
		return getContestName();
	}

	public String getOrganizer() {
		return organizer;
	}

	public ContestState getState() {
		return state;
	}

	public void setState(ContestState state) {
		this.state = state;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public int compareTo(ContestInfo contestInfo) {
		// return this.contestName.compareTo(contestInfo.contestName);
		return contestInfo.getStartTime().compareTo(this.getStartTime());
	}

	public String getOrgainzerEmail() {
		return getOrganizerEmail();
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setContestName(String contestName) {
		this.contestName = contestName;
	}

	public String getContestName() {
		return contestName;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setDurationHours(int durationHours) {
		this.durationHours = durationHours;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public void setOrganizerEmail(String organizerEmail) {
		this.organizerEmail = organizerEmail;
	}

	public String getOrganizerEmail() {
		return organizerEmail;
	}

	public void setContestId(long contestId) {
		this.contestId = contestId;
	}

	public long getContestId() {
		return contestId;
	}

}
