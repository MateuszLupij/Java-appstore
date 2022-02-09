package com.company;

import java.util.Random;

public class Worker {

    Skills[] skills;
    String name;

    public Worker(String name) {
        this.name = name;
        skills = getRandomSkills();
    }

    private Skills[] getRandomSkills(){
        int randomNumberOfSkills = new Random().nextInt(3);
        System.out.println("losowy numer");
        Skills[] tempSkills = new Skills[randomNumberOfSkills];
        for (int i = 0; i < randomNumberOfSkills; i ++ ){
           int randomNumber = new Random().nextInt(Skills.values().length);
           tempSkills[i] = Skills.values()[randomNumber];
        }


        return tempSkills;
    }




}
