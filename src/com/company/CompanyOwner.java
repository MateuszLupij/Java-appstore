package com.company;

public class CompanyOwner {

    String ownerName;
    String ownerSurname;
    Double cash;
    Skills [] ownerSkills;

    public CompanyOwner(String ownerName, String ownerSurname, Double cash, Skills[] ownerSkills) {
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.cash = cash;
        this.ownerSkills = ownerSkills;
    }

    public void SetUpSkills(CompanyOwner owner){
        owner.ownerSkills[0] = Skills.BACKEND;
        owner.ownerSkills[1] = Skills.DATA_BASE;
        owner.ownerSkills[2] = Skills.FRONT_END;
        owner.ownerSkills[3] = Skills.PRESTASHOP;
        owner.ownerSkills[4] = Skills.WORDPRESS;
        owner.ownerSkills[5] = Skills.MOBILE;
    }
}
