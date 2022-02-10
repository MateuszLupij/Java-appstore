package com.company;

import java.util.Random;

public class Client {
    String name;
    double chanceOfDelayThePayment = 30; // 30% na 7 dni(tydzien)
    double changeAvoidPenalty = 20; // 20% szans na uniknięcie kary za opóźnienie, jeżeli nie jest większe niż tydzień, oddanieniedziałającego projektu nie powoduje dodatkowych problemów
    double chanceToLoseProject = 0;
    double chanceOfDelayThePaymentMonth = 0;
    double chanceToTheyWantPay = 0;

    //TypeOfClient typeOfClient;

    public Client(String name) {
        this.name = name;
    }





    /*private void setTypeOfClient(){
        int randomNumber = new Random().nextInt(TypeOfClient.values().length);
        typeOfClient = TypeOfClient.values()[randomNumber];
    }*/

    }

