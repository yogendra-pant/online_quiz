package com.quiz.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class TrainingContest extends QuizContest {

	private static final long serialVersionUID = 1L;

	@Override
	@OneToMany(mappedBy = "contest")
	public List<Contestant> getContestants() {
		if (contestants == null) {
			contestants = new ArrayList<Contestant>();
		}
		return contestants;
	}

}
