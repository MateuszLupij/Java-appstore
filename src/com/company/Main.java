package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    static List<Project> listOfProjects = genFirstThreeProjects();
    static List<Client> listOfClients = getClientsFromProducts();

    public static void main(String[] args) {


        System.out.println(" Hello, lets play a game. Welcome to Company Simulator");

        boolean ingame = true;
        int counterTur = 1;
        LaidBack firstClientLaid = new LaidBack("Intel");

        Project pierwszProjekt = new Project("Pierwszy projekt", 1, firstClientLaid,
                LocalDate.of(2022, 2, 1), 150.00, 400.00, 15, ProjectAdvancementLvl.MEDIUM);

        LocalDate localDate = LocalDate.of(2020, 1, 1);
        CompanyOwner me = new CompanyOwner("Mateusz", "Loopy", 10000.00);
        me.addProjectToList(pierwszProjekt);


        List<Client> clientsForAgame = new ArrayList<>();

        clientsForAgame.add(findFirstClient());

        while (ingame) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("============" + localDate + "===============");
            System.out.println("You have take turn  " + counterTur + " money available " + me.cash);
            System.out.println("Chose the action");
            System.out.println("============Chose any action===========");
            System.out.println("1. Sign a contract for any available projects");
            System.out.println("2. Spend one day for a looking a customer (Every five days - it is a new customer)");
            System.out.println("3. Spend a day for programming ");
            System.out.println("4. Spend a day for testing  (you can get your own code, subcontractors code, also your workers code)");
            System.out.println("5. Give back the finished project");
            System.out.println("6. Hire new employee");
            System.out.println("7. Fire the employee");
            System.out.println("8. Spend a day for a pepper settlements with the offices(You have to spent at least 2 days in a month for taxes pepper, if not, they will hunt you down)");
            System.out.println("9. EXIT ");
            int i = scanner.nextInt();
            Random ramd = new Random();
            switch (i) {
                case 1:
                    System.out.println("=======SIGN A CONTRACT FOR PROJECT=======");
                    int counter = 1;
                    System.out.println("Choose project from the list");
                    for (Project p: listOfProjects) {
                        System.out.println(counter+". "+p.ProjectName + " price" + p.price + " for client:" + p.client.name);
                        counter++;
                    }
                    Scanner scanner1 = new Scanner(System.in);
                    me.addProjectToList(listOfProjects.get(scanner1.nextInt()-1));
                    //System.out.println(me.getListOfProjects());
                    break;
                case 2:
                    System.out.println("=======ADD CLIENT to a LIST========");
                    me.addClientToList(clientsForAgame.get(ramd.nextInt()));
                    System.out.println(me.getListOfClient());
                    break;
                case 3:
                    System.out.println("======SPEND DAY FOR A PROGRAMMING=======");
                    List<Project> listOfProjectsToFnish = me.getListOfProjects();
                    if (listOfProjectsToFnish.size() > 0) {
                        Project project = listOfProjectsToFnish.get(ramd.nextInt(listOfProjectsToFnish.size() - 1));
                        project.numberOfDaysToFinish = project.numberOfDaysToFinish - 1;
                    } else {
                        System.out.println("There is no project to work on them, you lost a day :( ");
                    }
                    break;
                case 4:
                    System.out.println("========TESTING========");
                    break;
                case 5:
                    int size = me.listOfProjects.size();
                    for (Project p : me.listOfProjects) {
                        if (p.numberOfDaysToFinish == 0) {
                            me.listOfProjects.remove(p);
                            me.cash += p.price;
                            System.out.println("====Project finished====" + p.ProjectName + " you get: " + p.price + "Congratulation");
                        }

                    }
                    if (size == me.listOfProjects.size()) {
                        System.out.println("There is no project to work on them, you lost a day :( ");
                    }

                    break;
                case 6:
                    int size1 = me.getListOfWorkers().size();
                    Worker worker = new Worker("Employee " + size1, 30);
                    me.getListOfWorkers().add(worker);
                    System.out.println("You employed " + worker.name + " for " + worker.payDay);
                    break;
                case 7:
                    int counterWorker = 1;
                    System.out.println("===WORKERS TO FIRE===");
                    for (Worker w: me.listOfWorkers) {

                        System.out.println(counterWorker+". "+w.name);
                        counterWorker++;
                    }
                    Scanner indexDousuniecia = new Scanner(System.in);

                    System.out.println("Pick a number to delete a employee from 1 " + me.getListOfWorkers().size());
                    me.listOfWorkers.remove(indexDousuniecia.nextInt()-1);

                    break;
                case 9:

                    System.out.println("========== END OF THE GAME============");
                    ingame = false;
                    break;
            }

            localDate = localDate.plusDays(1);
            counterTur++;
            double toPay = countFixedCosts(me);
            if (me.cash < toPay) {
                System.out.println("You have no money, you lost the game. Sorry ");
                ingame = false;
            } else {
                me.cash = me.cash - toPay;
            }
            if (counterTur % 5 == 0) {
                Random rand = new Random();
                clientsForAgame.add(listOfClients.get(rand.nextInt(listOfClients.size() - 1)));
            }
        }
    }

    private static double countFixedCosts(CompanyOwner boss) {
        List<Worker> listOfWorkers = boss.getListOfWorkers();
        double moneyToPay = 0;
        double rentOfOffice = 50;
        for (Worker w : listOfWorkers) {
            moneyToPay += w.payDay;
        }
        moneyToPay = moneyToPay + rentOfOffice;

        return moneyToPay;
    }

    private static Client findFirstClient() {
        return listOfClients.get(0);
    }


    private static List<Project> genFirstThreeProjects() {
        List<Project> listOfProjects = new ArrayList<>();

        Demanding demaning = new Demanding("Optimus");
        LaidBack laidBack = new LaidBack("CCI");
        SQ sq = new SQ("CD-Project");


        Project project1 = new Project("Computer App", 1, demaning, LocalDate.of(2022, 1, 15), 50000.0, 50000.0, 30, ProjectAdvancementLvl.EASY);
        demaning.project = project1;
        Project project2 = new Project("App for the town Hall ", 1, laidBack, LocalDate.of(2022, 5, 4), 180000.0, 320000.0, 60, ProjectAdvancementLvl.MEDIUM);
        laidBack.project = project2;
        Project project3 = new Project("APP for NASA", 1, sq, LocalDate.of(2022, 4, 1), 500000.0, 1500000.0, 21, ProjectAdvancementLvl.HARD);
        sq.project = project3;
        listOfProjects.add(project1);
        listOfProjects.add(project2);
        listOfProjects.add(project3);


        return listOfProjects;
    }

    private static List<Client> getClientsFromProducts() {
       /* List<Client> listClient = new ArrayList<>();
        listClient.add(new Client("CCI"));
        listClient.add(new Client("Optimus"));
        listClient.add(new Client("Microsoft"));
        listClient.add(new Client("Blizzard"));
        Client cci = new Client("CCI");*/
        List<Client> listClient = new ArrayList<>();
        for (Project c : listOfProjects) {
            listClient.add(c.getClient());
        }
        return listClient;
    }

    private static List<Client> clientWithProjects() {

        List<Client> listClient = new ArrayList<>();

        //Project project1 = new Project("Computer App", 60, new Client("Januszex Limited"), LocalDate.of(2022, 1, 15), 50000.0, 50000.0, 30, ProjectAdvancementLvl.EASY);
        Client demaning = new Demanding("Optimus");


        //Project project2 = new Project("App for the town Hall ", 180, new Client("Town Hall of Gdansk"), LocalDate.of(2022, 5, 4), 180000.0, 320000.0, 60, ProjectAdvancementLvl.MEDIUM);
        Client laidBack = new LaidBack("CCI");


        //Project project3 = new Project("APP for NASA", 365, new Client("National Aeronautics and Space Administration"), LocalDate.of(2022, 4, 1), 500000.0, 1500000.0, 21, ProjectAdvancementLvl.HARD);
        Client sq = new SQ("CD-Project");


        listClient.add(demaning);
        listClient.add(laidBack);
        listClient.add(sq);


        return listClient;


    }


}
