package com.company.client;

import com.company.client.Client;

public class Inexperienced extends Client {
    public Inexperienced(String name) {
        super(name);
    }

    double chanceOfDelayThePayment = 0;
    double chanceAvoidPenalty = 100;
    double chanceToLoseProject = 0;
    double chanceOfDelayThePaymentMonth = 0;
    double chanceToTheyWantPay = 0;

    @Override
    public String toString() {
        return "Inexperienced{" +
                "chanceOfDelayThePayment=" + chanceOfDelayThePayment +
                ", chanceAvoidPenalty=" + chanceAvoidPenalty +
                ", chanceToLoseProject=" + chanceToLoseProject +
                ", chanceOfDelayThePaymentMonth=" + chanceOfDelayThePaymentMonth +
                ", chanceToTheyWantPay=" + chanceToTheyWantPay +
                '}';
    }
}
