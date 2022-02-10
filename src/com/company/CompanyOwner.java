package com.company;

import java.util.ArrayList;
import java.util.List;

public class CompanyOwner {

    String ownerName;
    String ownerSurname;
    Double cash;
    Skills [] ownerSkills = {Skills.BACKEND, Skills.DATA_BASE, Skills.FRONT_END, Skills.WORDPRESS,Skills.PRESTASHOP};
    List<Worker> listOfWorkers = new ArrayList<>();
    List<Project> listOfProjects = new ArrayList<>();
    List<Client>  listOfClient = new ArrayList<>();

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

    public void addProjectToList(Project project){
        listOfProjects.add(project);
    }

    public void addClientToList(Client client){
        listOfClient.add(client);
    }

    //getters setters


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Skills[] getOwnerSkills() {
        return ownerSkills;
    }

    public void setOwnerSkills(Skills[] ownerSkills) {
        this.ownerSkills = ownerSkills;
    }

    public List<Worker> getListOfWorkers() {
        return listOfWorkers;
    }

    public void setListOfWorkers(List<Worker> listOfWorkers) {
        this.listOfWorkers = listOfWorkers;
    }

    public List<Project> getListOfProjects() {
        return listOfProjects;
    }

    public void setListOfProjects(List<Project> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public List<Client> getListOfClient() {
        return listOfClient;
    }

    public void setListOfClient(List<Client> listOfClient) {
        this.listOfClient = listOfClient;
    }
}
