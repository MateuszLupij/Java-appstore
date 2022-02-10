package com.company;

import java.time.LocalDate;
import java.util.Random;

public class Project {

    String ProjectName;
    int numberOfDaysToFinish;
    Client client;
    LocalDate dateOfDelivery;
    double penaltyForNotReturningTheProject;
    double price;
    int deadlineForPayment;
    ProjectAdvancementLvl projectAdvancementLvl;
    Skills projectType;

    public Project(String projectName, int numberOfDaysToFinish, Client client, LocalDate dateOfDelivery, double penaltyForNotReturningTheProject, double price, int deadlineForPayment, ProjectAdvancementLvl projectAdvancementLvl) {
        ProjectName = projectName;
        this.numberOfDaysToFinish = numberOfDaysToFinish;
        this.client = client;
        this.dateOfDelivery = dateOfDelivery;
        this.penaltyForNotReturningTheProject = penaltyForNotReturningTheProject;
        this.price = price;
        this.deadlineForPayment = deadlineForPayment;
        this.projectAdvancementLvl = projectAdvancementLvl;
        projectType = genProjectType();
    }


    private Skills genProjectType(){
        int randomNumber = new Random().nextInt(Skills.values().length);
        return Skills.values()[randomNumber];
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "Project{" +
                "ProjectName='" + ProjectName + '\'' +
                ", numberOfDaysToFinish=" + numberOfDaysToFinish +
                ", client=" + client +
                '}';
    }
}
