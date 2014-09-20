/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.entities;

import com.quiz.shared.entities.ContestState;
import java.util.Date;

/**
 *
 * @author Yogendra
 */
public class ContestProxy {
    private String name;
    private String gameName;
    private Date startTime;
    private int durationHours;
    private int durationMinutes;
    private String organizerEmail;
    private String organizer;

    public ContestProxy(){
        
    }
    public ContestProxy(String name, String gameName, Date startTime, int durationHours, int durationMinutes, String organizerEmail, String organizer) {
        this.name = name;
        this.gameName = gameName;
        this.startTime = startTime;
        this.durationHours = durationHours;
        this.durationMinutes = durationMinutes;       
        this.organizerEmail = organizerEmail;
        this.organizer = organizer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }
    

}
