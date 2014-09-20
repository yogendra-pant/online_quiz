package com.quiz.shared.entities;



public class LevelInfo{

	private int nrOfLevels;
	private int currentLevel;
	private int selectedLevel;
	private boolean gameFinished;

	public LevelInfo() {

	}

	public LevelInfo(int nrOflevels, int currentLevel, int selectedLevel, boolean gameFinished) {
		this.nrOfLevels = nrOflevels;
		this.currentLevel = currentLevel;
		this.gameFinished = gameFinished;
		this.setSelectedLevel(selectedLevel);
	}

	public void setNrOfLevels(int nrOfLevels) {
		this.nrOfLevels = nrOfLevels;
	}

	public int getNrOfLevels() {
		return nrOfLevels;
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

	public void setGameFinished(boolean gameFinished) {
		this.gameFinished = gameFinished;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	public boolean isLastLevel() {
		return nrOfLevels == selectedLevel;
	}

}
