package com.company.client;

import com.company.client.Client;

public class Dominant extends Client {
    public Dominant(String name) {
        super(name);
    }

    double chanceOfDelayThePayment = 50;
    double chanceAvoidPenalty = 0;
    double chanceToLoseProject = 100;
    double chanceOfDelayThePaymentMonth = 50;
    double chanceToTheyWantPay = 50;

    @Override
    public String toString() {
        return "Dominant{" +
                "chanceOfDelayThePayment=" + chanceOfDelayThePayment +
                ", chanceAvoidPenalty=" + chanceAvoidPenalty +
                ", chanceToLoseProject=" + chanceToLoseProject +
                ", chanceOfDelayThePaymentMonth=" + chanceOfDelayThePaymentMonth +
                ", chanceToTheyWantPay=" + chanceToTheyWantPay +
                '}';
    }
}
