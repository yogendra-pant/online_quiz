package com.quiz.entities;

public class Times {
	private String startTimeAbsolute;
	private String timeToStartRelative;
	private String endTimeAbsolute;
	private String timeToEndRelative;

	public Times(String startTimeAbsolute, String timeToStartRelative, String endTimeAbsolute, String timeToEndRelative) {
		this.startTimeAbsolute = startTimeAbsolute;
		this.timeToStartRelative = timeToStartRelative;
		this.endTimeAbsolute = endTimeAbsolute;
		this.timeToEndRelative = timeToEndRelative;
	}

	public String getEndTimeAbsolute() {
		return endTimeAbsolute;
	}

	public String getStartTimeAbsolute() {
		return startTimeAbsolute;
	}

	public String getTimeToEndRelative() {
		return timeToEndRelative;
	}

	public String getTimeToStartRelative() {
		return timeToStartRelative;
	}
	//public String getDuration() { }
}
