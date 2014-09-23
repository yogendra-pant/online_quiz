package com.quiz.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class QuizSolution extends EntityObject{

    private static final long serialVersionUID = 1L;
    
    private String name;

    private String displayName;

    private String description;
    
    private String question;
    private String solution;
    private int point;
    
    private Visibility visibility;
    
    private List<QuestionSolution> questionSolutions=new ArrayList<QuestionSolution>();
    
    public QuizSolution(){
        
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    public List<QuestionSolution> getQuestionSolutions() {
        return questionSolutions;
    }

    public void setQuestionSolutions(List<QuestionSolution> questionSolutions) {
        this.questionSolutions = questionSolutions;
    }
    
    @Transient
    public int getNrOfQuestions(){
        return questionSolutions.size();
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return getId()+":"+displayName;
    }

}
