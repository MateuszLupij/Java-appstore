package com.company.client;

import com.company.client.Client;

public class Demanding extends Client {
    public Demanding(String name) {
        super(name);
    }

    double chanceOfDelayThePayment = 0;
    double chanceAvoidPenalty = 0;
    double chanceToLoseProject = 50; // 50% szans na utratę kontraktu bez zwrotu kosztów
    double chanceOfDelayThePaymentMonth = 0;
    double chanceToTheyWantPay = 0;

    @Override
    public String toString() {
        return "Demanding{" +
                "chanceOfDelayThePayment=" + chanceOfDelayThePayment +
                ", chanceAvoidPenalty=" + chanceAvoidPenalty +
                ", chanceToLoseProject=" + chanceToLoseProject +
                ", chanceOfDelayThePaymentMonth=" + chanceOfDelayThePaymentMonth +
                ", chanceToTheyWantPay=" + chanceToTheyWantPay +
                '}';
    }
}
