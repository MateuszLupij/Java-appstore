package com.company;

import java.util.ArrayList;
import java.util.List;

public class CompanyOwner {

    String ownerName;
    String ownerSurname;
    Double cash;
    Skills [] ownerSkills = {Skills.BACKEND, Skills.DATA_BASE, Skills.FRONT_END, Skills.WORDPRESS,Skills.PRESTASHOP};
    List<Worker> listOfWorkers = new ArrayList<>();

    public CompanyOwner(String ownerName, String ownerSurname, Double cash) {
        this.ownerName = ownerName;
        this.ownerSurname = ownerSurname;
        this.cash = cash;
    }

    public void  addWorkers(Worker worker) {
        listOfWorkers.add(worker);
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
