package com.company;

import com.company.client.*;
import com.company.workers.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;

public class Main {

    static List<Project> listOfProjects = genFirstThreeProjects();
    static List<Client> listOfClients = getClientsFromProducts();
    static List<Worker> workersList = getListOfWorkers();

    public static void main(String[] args) {


        System.out.println(" Hello, lets play a game. Welcome to Company Simulator");

        boolean ingame = true;
        int counterTur = 1;
        LaidBack firstClientLaid = new LaidBack("Intel");

        Project pierwszProjekt = new Project("My first project", 1, firstClientLaid,
                LocalDate.of(2022, 2, 1), 150.00, 400.00, 15, ProjectAdvancementLvl.MEDIUM);
        firstClientLaid.project = pierwszProjekt;
        LocalDate localDate = LocalDate.of(2020, 1, 1);
        Month month = localDate.getMonth();

        CompanyOwner me = new CompanyOwner("Mateusz", "Loopy", 10000.00);
        me.addClientToList(firstClientLaid);


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
            System.out.print("====CHOSE THE ACTION==> ");
            int i = scanner.nextInt();

            Random ramd = new Random();
            switch (i) {
                case 1:
                    System.out.println("=======SIGN A CONTRACT FOR PROJECT=======");
                    int counter = 1;
                    System.out.println("Choose project from the list of your clients");
                    List<Project> listOfYourClientsProjects = getListOfYourClients(me);
                    for (Project p: listOfYourClientsProjects) {
                        System.out.println(counter+". "+p.ProjectName + " price" + p.price + " for client:" + p.client.name);
                        counter++;
                    }
                    Scanner scanner1 = new Scanner(System.in);
                    me.addProjectToList(listOfProjects.get(scanner1.nextInt()-1));
                    //System.out.println(me.getListOfProjects());
                    break;
                case 2:
                    System.out.println("=======ADD CLIENT to a LIST========");
                    if(clientsForAgame.size() == 1) {


                        me.addClientToList(clientsForAgame.get(0));
                        System.out.println(me.getListOfClient());
                    }else if(clientsForAgame.size() > 1){
                        me.addClientToList(clientsForAgame.get(ramd.nextInt(clientsForAgame.size() -1)));
                        System.out.println(me.getListOfClient());
                    } else {
                        System.out.println("There are not clients available for your at the moment wait" + (counterTur % 5) + " days for next client");
                    }

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
                        System.out.println("There is finished project to sign off - you lost a day :( ");
                    }

                    break;
                case 6:

                    System.out.println("===AVAILABLE WORKERS===");
                    int workerCounter = 1;
                    for (Worker worker: workersList) {
                        System.out.println(workerCounter + ". " + worker.name + " " + worker.payDay + " " + worker.getClass().getSimpleName());
                        workerCounter++;
                    }
                    System.out.println("=====CHOSE WORKER TO HIRE=====");
                    Scanner scannerWorker = new Scanner(System.in);
                    int choosenWorker = scannerWorker.nextInt();

                    me.getListOfWorkers().add(workersList.get(choosenWorker-1));
                    workersList.remove(choosenWorker-1);


                    /*int size1 = me.getListOfWorkers().size();
                    Worker worker = new Worker("Employee " + size1, 30);
                    me.getListOfWorkers().add(worker);
                    System.out.println("You employed " + worker.name + " for " + worker.payDay);*/
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
                case 8:
                    me.setDaysForZus(me.getDaysForZus()+1);
                    break;
                case 9:

                    System.out.println("========== END OF THE GAME============");
                    ingame = false;
                    break;
            }

            int monthValue = localDate.getMonthValue();
            localDate = localDate.plusDays(1);
            int monthValueAfterChange = localDate.getMonthValue();
            if(monthValue != monthValueAfterChange){
                if(me.getDaysForZus() < 2){
                    System.out.println("=========BRANKRUT=======");
                    ingame = false;
                    break;
                }else {
                    System.out.println("ZUS DOES NOT HAVE ANY OBJECTIVES");
                }
            }
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

    private static  List<Project> getListOfYourClients(CompanyOwner owner) {
        List<Client> listOfClient = owner.getListOfClient();
        List<Project> listOfProjectOfMyClients  = new ArrayList<>();
        for (Client client:listOfClient) {
            listOfProjectOfMyClients.add(client.project);

        }
        return  listOfProjectOfMyClients;
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

        Demanding demanding = new Demanding("Optimus");
        LaidBack laidBack = new LaidBack("CCI");
        SQ sq = new SQ("CD-Project");
        Cautious cautious = new Cautious("Jojo");
        Dominant dominant = new Dominant("Rage");
        Inexperienced inexperienced = new Inexperienced("Baby Drive");

        Project project1 = new Project("Computer App", 1, demanding, LocalDate.of(2022, 1, 15), 50000.0, 50000.0, 30, ProjectAdvancementLvl.EASY);
        demanding.project = project1;
        Project project2 = new Project("App for the town Hall ", 1, laidBack, LocalDate.of(2022, 5, 4), 180000.0, 320000.0, 60, ProjectAdvancementLvl.MEDIUM);
        laidBack.project = project2;
        Project project3 = new Project("APP for NASA", 1, sq, LocalDate.of(2022, 4, 1), 500000.0, 1500000.0, 21, ProjectAdvancementLvl.HARD);
        sq.project = project3;
        Project project4 = new Project("Toilet app",10,cautious,LocalDate.of(2022,1,10),5000.0,10000,10,ProjectAdvancementLvl.EASY);
        cautious.project = project4;
        Project project5 = new Project("Cleaning app", 10,dominant,LocalDate.of(2022,3,1),1000, 5000,10,ProjectAdvancementLvl.EASY);
        dominant.project = project5;
        Project project6 = new Project("Driving app", 2,inexperienced,LocalDate.of(2022,1,15),1,100, 10,ProjectAdvancementLvl.EASY);
        inexperienced.project = project6;

        listOfProjects.add(project1);
        listOfProjects.add(project2);
        listOfProjects.add(project3);
        listOfProjects.add(project4);
        listOfProjects.add(project5);
        listOfProjects.add(project6);


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
        Client demanding = new Demanding("Optimus");


        //Project project2 = new Project("App for the town Hall ", 180, new Client("Town Hall of Gdansk"), LocalDate.of(2022, 5, 4), 180000.0, 320000.0, 60, ProjectAdvancementLvl.MEDIUM);
        Client laidBack = new LaidBack("CCI");


        //Project project3 = new Project("APP for NASA", 365, new Client("National Aeronautics and Space Administration"), LocalDate.of(2022, 4, 1), 500000.0, 1500000.0, 21, ProjectAdvancementLvl.HARD);
        Client sq = new SQ("CD-Project");
        Client cautious = new Cautious("Jojo");
        Client dominant = new Dominant("Rage");
        Client inexperienced = new Inexperienced("Baby Drive");


        listClient.add(demanding);
        listClient.add(laidBack);
        listClient.add(sq);
        listClient.add(cautious);
        listClient.add(dominant);
        listClient.add(inexperienced);


        return listClient;


    }

    public static List<Worker> getListOfWorkers(){

        Worker businessAnalytics = new BusinessAnalytic("Roman");
        Worker devOps = new DevOps("Wojtek");
        Worker program = new Programmer("Ilona");
        Worker seller = new Seller("Kasia");
        Worker softwareArchitect = new SoftwareArchitect("Adam");
        Worker tester = new Tester("Krystian");
        Worker trainee = new Trainee("Magda");

        List<Worker> listOfWorkers = new ArrayList<>();
        listOfWorkers.add(businessAnalytics);
        listOfWorkers.add(devOps);
        listOfWorkers.add(program);
        listOfWorkers.add(seller);
        listOfWorkers.add(softwareArchitect);
        listOfWorkers.add(tester);
        listOfWorkers.add(trainee);

        return listOfWorkers;
    }


}
