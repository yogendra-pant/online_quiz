/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.entities;

import com.quiz.shared.entities.ContestState;
import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Yogendra
 */
public class ContestProxy {
    @NotNull
    @NotEmpty
    private String contestName;
//    @NotNull
//    @NotEmpty
//    @Pattern(regexp="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d")
//    @Future
    private Date contestDate;
//    @NotNull
//    @NotEmpty    
//    @Pattern(regexp="^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")
    private Date startTime;
//    @NotNull
//    @NotEmpty
    //@Pattern(regexp="^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")
    private int contestDuration;
    @NotNull
    @NotEmpty
    @Email
    private String organizerEmail;
    @NotNull
    @NotEmpty
    private String organizerName;

    public ContestProxy(){
        
    }

    public ContestProxy(String contestName, Date contestDate, Date startTime, int contestDuration, String organizerEmail, String organizerName) {
        this.contestName = contestName;
        this.contestDate = contestDate;
        this.startTime = startTime;
        this.contestDuration = contestDuration;
        this.organizerEmail = organizerEmail;
        this.organizerName = organizerName;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public Date getContestDate() {
        return contestDate;
    }

    public void setContestDate(Date contestDate) {
        this.contestDate = contestDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getContestDuration() {
        return contestDuration;
    }

    public void setContestDuration(int contestDuration) {
        this.contestDuration = contestDuration;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }
    
   

}
