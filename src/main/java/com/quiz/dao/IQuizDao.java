package com.quiz.dao;

import com.quiz.entities.Quiz;
import com.quiz.entities.Visibility;

import java.util.List;


public interface IQuizDao {

	List<Quiz> getAvailableQuiz(Visibility visibility);

	void storeQuiz(Quiz game);

	Quiz getQuiz(long id);

	void updateQuiz(Quiz game);

	void deleteQuiz(Quiz game);
}
