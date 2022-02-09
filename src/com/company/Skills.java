package com.company;

public enum Skills {

    PRESTASHOP(5), WORDPRESS(30), MOBILE(30), DATA_BASE(30), BACKEND(45), FRONT_END(34),;

    final double numberOfDays;
    Skills(int numberOfDaysForCompletion) {
        numberOfDays = numberOfDaysForCompletion;
    }

}
