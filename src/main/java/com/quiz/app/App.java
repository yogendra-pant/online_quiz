/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quiz.app;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Yogendra
 */
public class App {
    public static void main(String[] args) {
    
       Calendar cal=Calendar.getInstance();
       cal.setTimeInMillis(System.currentTimeMillis()+10*24*60*60*1000);
       System.out.println(cal.getTime());
    }
}
