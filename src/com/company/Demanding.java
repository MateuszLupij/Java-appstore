package com.company;

public class Demanding extends Client{
    public Demanding(String name) {
        super(name);
    }

    double chanceOfDelayThePayment = 0;
    double chanceAvoidPenalty = 0;
    double chanceToLoseProject = 50; // 50% szans na utratę kontraktu bez zwrotu kosztów
    double chanceOfDelayThePaymentMonth = 0;
    double chanceToTheyWantPay = 0;
}
