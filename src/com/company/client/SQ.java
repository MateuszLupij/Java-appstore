package com.company.client;

import com.company.client.Client;

public class SQ extends Client {
    public SQ(String name) {
        super(name);
    }

    double chanceOfDelayThePayment = 30;
    double chanceAvoidPenalty = 0;
    double chanceToLoseProject = 100;
    double chanceOfDelayThePaymentMonth = 5;
    double chanceToTheyWantPay = 1;

    @Override
    public String toString() {
        return "SQ{" +
                "chanceOfDelayThePayment=" + chanceOfDelayThePayment +
                ", chanceAvoidPenalty=" + chanceAvoidPenalty +
                ", chanceToLoseProject=" + chanceToLoseProject +
                ", chanceOfDelayThePaymentMonth=" + chanceOfDelayThePaymentMonth +
                ", chanceToTheyWantPay=" + chanceToTheyWantPay +
                '}';
    }
}
