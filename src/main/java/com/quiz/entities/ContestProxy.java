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

    public ContestProxy(String name, String gameName, Date startTime, int durationHours, int durationMinutes, String organizerEmail, String organizer) {
        this.name = name;
        this.gameName = gameName;
        this.startTime = startTime;
        this.durationHours = durationHours;
        this.durationMinutes = durationMinutes;       
        this.organizerEmail = organizerEmail;
        this.organizer = organizer;
    }
    

}
