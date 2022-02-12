package com.company.workers;

import com.company.Skills;

import java.util.Random;

public class Worker {

    public Skills[] skills;
    public String name;
    //dniowka
    public Double payDay;

    double knowledge = 20;
    double accuracy = 10;
    double punctuality = 10;


    public Worker(String name, double payDay, double knowledge, double accuracy, double punctuality) {
        this.payDay = payDay;
        this.name = name;
        this.knowledge = knowledge;
        this.accuracy = accuracy;
        this.punctuality = punctuality;

        skills = getRandomSkills();
    }

    private Skills[] getRandomSkills(){
        int randomNumberOfSkills = new Random().nextInt(3);
        //System.out.println("random number: ");
        Skills[] tempSkills = new Skills[randomNumberOfSkills];
        for (int i = 0; i < randomNumberOfSkills; i ++ ){
           int randomNumber = new Random().nextInt(Skills.values().length);
           tempSkills[i] = Skills.values()[randomNumber];
        }


        return tempSkills;
    }




}
