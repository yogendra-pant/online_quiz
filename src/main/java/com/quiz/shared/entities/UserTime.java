package com.quiz.shared.entities;



public class UserTime {

	private double duration;

	private boolean paused;

	public UserTime() {

	}

	public UserTime(double duration, boolean paused) {
		this.duration = duration;
		this.paused = paused;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getDuration() {
		return duration;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public boolean isPaused() {
		return paused;
	}

}
