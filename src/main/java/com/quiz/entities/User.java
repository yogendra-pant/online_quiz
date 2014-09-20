/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quiz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


/**
 *
 * @author Yogendra
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @NotNull
    @NotEmpty
    private String userName;
    @NotNull
    @NotEmpty
    @Email
    private String emailId;
   @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    @NotNull
    @NotEmpty
    private String password;
    @Transient
    private String confirmPassword;

       
    public User() {
    }

    public User(String userName, String phoneNumber,String emailID, String password, String cofirmPassword) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.emailId=emailID;
        this.confirmPassword=cofirmPassword;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailID) {
        this.emailId = emailID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public long getId(){
        return userId;
    }

}
