package com.company.client;

import com.company.client.Client;

public class LaidBack extends Client {
    public LaidBack(String name) {
        super(name);
    }

    double chanceOfDelayThePayment = 30; // 30% na 7 dni(tydzien)
    double changeAvoidPenalty = 20; // 20% szans na uniknięcie kary za opóźnienie, jeżeli nie jest większe niż tydzień, oddanieniedziałającego projektu nie powoduje dodatkowych problemów
    double chanceToLoseProject = 0;
    double chanceOfDelayThePaymentMonth = 0;
    double chanceToTheyWantPay = 0;

    @Override
    public String toString() {
        return "LaidBack{" +
                "chanceOfDelayThePayment=" + chanceOfDelayThePayment +
                ", changeAvoidPenalty=" + changeAvoidPenalty +
                ", chanceToLoseProject=" + chanceToLoseProject +
                ", chanceOfDelayThePaymentMonth=" + chanceOfDelayThePaymentMonth +
                ", chanceToTheyWantPay=" + chanceToTheyWantPay +
                '}';
    }
}
