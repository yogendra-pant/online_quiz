package com.quiz.entities;

import com.quiz.shared.entities.ContestState;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity
public class ScheduledContest extends QuizContest {

	private static final long serialVersionUID = 1L;

	private Date startTime;

	private int durationHours;

	private int durationMinutes;

	private ContestState contestState;

	private String organizerEmail;

	private String organizer;

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setDurationHours(int durationHours) {
		this.durationHours = durationHours;
	}

	public int getDurationHours() {
		return durationHours;
	}

	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}

	public int getDurationMinutes() {
		return durationMinutes;
	}

	public void setContestState(ContestState contestState) {
		this.contestState = contestState;
	}

	public ContestState getContestState() {
		return contestState;
	}

	public String getOrganizerEmail() {
		return organizerEmail;
	}

	public void setOrganizerEmail(String organizerEmail) {
		this.organizerEmail = organizerEmail;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getOrganizer() {
		return organizer;
	}

	@Override
	@OneToMany(mappedBy = "contest")
	public List<Contestant> getContestants() {
		if (contestants == null) {
			contestants = new ArrayList<Contestant>();
		}
		return contestants;
	}

}
