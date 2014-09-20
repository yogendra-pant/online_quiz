package com.quiz.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;


@Entity
public class LevelTimer extends EntityObject {

	private static final long serialVersionUID = 7420559690521136249L;

	private Contestant contestant;

	private int level;

	private double duration;

	private int levelTestFails;
        
        public LevelTimer(){
            
        }

	public void setContestant(Contestant contestant) {
		this.contestant = contestant;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@ForeignKey(name = "FK_LEVEL_TIMER_TO_CONTESTANT")
	public Contestant getContestant() {
		return contestant;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getDuration() {
		return duration;
	}

	public void setLevelTestFails(int testFails) {
		this.levelTestFails = testFails;
	}

	public int getLevelTestFails() {
		return levelTestFails;
	}

}
