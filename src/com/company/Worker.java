package com.company;

import java.util.Random;

public class Worker {

    Skills[] skills;
    String name;
    //dniowka
    Double payDay;

    public Worker(String name, double payDay) {
        this.payDay = payDay;
        this.name = name;
        skills = getRandomSkills();
    }

    private Skills[] getRandomSkills(){
        int randomNumberOfSkills = new Random().nextInt(3);
        System.out.println("random number: ");
        Skills[] tempSkills = new Skills[randomNumberOfSkills];
        for (int i = 0; i < randomNumberOfSkills; i ++ ){
           int randomNumber = new Random().nextInt(Skills.values().length);
           tempSkills[i] = Skills.values()[randomNumber];
        }


        return tempSkills;
    }




}
