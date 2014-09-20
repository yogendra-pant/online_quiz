package com.quiz.shared.entities;



public class TestCase{

	private String id;

	private String question;

	public TestCase() {

	}

	public TestCase(String id, String question) {
		this.setId(id);
		this.question = question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
