package com.company;

public enum TypeOfClient {

    LAID_BACK(30,20,0,0,0),
    DEMANDING(0,0,50,0,0),
    SQ(30,0,100, 5,1),
    Cautious(15,10,50,50,10),
    Dominant(50,0,100,50,0),
    Inexperienced(0,100,0,0,0);



    int chanceOfDelay;
    int chanceAvoidPenalty;
    int chanceToLoseProject;
    int chanceOfDelayThePaymentMonth;
    int chanceToTheyWantPay;




    TypeOfClient(int chanceOfDelay, int chanceAvoidPenalty, int chanceToLoseProject, int chanceOfDelayThePaymentMonth, int chanceToTheyWantPay) {
        this.chanceOfDelay = chanceOfDelay;
        this.chanceAvoidPenalty = chanceAvoidPenalty;
        this.chanceToLoseProject = chanceToLoseProject;
        this.chanceOfDelayThePaymentMonth = chanceOfDelayThePaymentMonth;
        this.chanceToTheyWantPay = chanceToTheyWantPay;
    }
}
