/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.shared.entities;

import com.quiz.shared.entities.ContestState;
import java.util.Date;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Yogendra
 */
public class ContestInfo {

    private long contestId;
    @NotNull
    @NotEmpty
    private String contestName;
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    @Future
    private Date contestDate;
    @NotNull
    @DateTimeFormat(pattern = "hh:mm:ss")
    private Date contestDuration;
    @NotNull
    @NotEmpty
    @Email
    private String organizerEmail;
    @NotNull
    @NotEmpty
    private String organizerName;

    private ContestState contestState;

    public ContestInfo() {

    }

    public ContestInfo(String contestName, Date contestDate, Date startTime, Date contestDuration, String organizerEmail, String organizerName) {
        this.contestName = contestName;
        this.contestDate = contestDate;
        this.contestDuration = contestDuration;
        this.organizerEmail = organizerEmail;
        this.organizerName = organizerName;
    }

    public ContestState getContestState() {
        return contestState;
    }

    public void setContestState(ContestState contestState) {
        this.contestState = contestState;
    }

    public long getContestId() {
        return contestId;
    }

    public void setContestId(long contestId) {
        this.contestId = contestId;
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

    public Date getContestDuration() {
        return contestDuration;
    }

    public void setContestDuration(Date contestDuration) {
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
