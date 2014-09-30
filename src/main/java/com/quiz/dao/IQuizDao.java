package com.quiz.dao;

import com.quiz.entities.Quiz;
import com.quiz.entities.QuizSolution;
import java.util.List;

public interface IQuizDao {

    public List<Quiz> getAllQuiz();

    public void storeQuiz(Quiz game);

    public void storeQuizSolution(QuizSolution game);

    public Quiz getQuiz(long id);

    public void updateQuiz(Quiz game);

    public void deleteQuiz(Quiz game);
}
