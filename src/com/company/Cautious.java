package com.company;

public class Cautious extends Client{
    public Cautious(String name) {
        super(name);
    }

    double chanceOfDelayThePayment = 15;
    double chanceAvoidPenalty = 10;
    double chanceToLoseProject = 50;
    double chanceOfDelayThePaymentMonth = 50;
    double chanceToTheyWantPay = 10;
}
