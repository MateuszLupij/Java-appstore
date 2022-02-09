package com.company;

import java.time.LocalDate;

public class Project {

    String ProjectName;
    int numberOfDaysToFinish;
    Client client;
    LocalDate dateOfDelivery;
    double penaltyForNotReturningTheProject;
    double price;
    LocalDate deadlineForPayment;
    ProjectAdvancementLvl projectAdvancementLvl;

    public Project(String projectName, int numberOfDaysToFinish, Client client, LocalDate dateOfDelivery, double penaltyForNotReturningTheProject, double price, LocalDate deadlineForPayment, ProjectAdvancementLvl projectAdvancementLvl) {
        ProjectName = projectName;
        this.numberOfDaysToFinish = numberOfDaysToFinish;
        this.client = client;
        this.dateOfDelivery = dateOfDelivery;
        this.penaltyForNotReturningTheProject = penaltyForNotReturningTheProject;
        this.price = price;
        this.deadlineForPayment = deadlineForPayment;
        this.projectAdvancementLvl = projectAdvancementLvl;
    }


    /*public Project(String projectName, ProjectAdvancementLvl[] projectTypes, Integer amountOfWorkDays, ProjectAdvancementLvl[] improveYourself) {
        this.ProjectName = projectName;
        this.projectTypes = projectTypes;
        this.amountOfWorkDays = amountOfWorkDays;
        this.improveYourself = improveYourself;
    }

    ProjectAdvancementLvl [] projectTypes;
    Integer amountOfWorkDays;
    ProjectAdvancementLvl[] improveYourself;*/






}
