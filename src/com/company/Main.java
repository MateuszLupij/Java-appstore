package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Hello, lets play a game. Welcome to Company Simulator");

        boolean ingame = true;
        while(ingame) {
            CompanyOwner me = new CompanyOwner("Mateusz", "Loopy", 20.00);
            Scanner scanner = new Scanner(System.in);
            System.out.println("============Wybierz jeden, żeby rozpoczać turę===========");
            int i = scanner.nextInt();
            if(i == 1){
                System.out.println("Kolejna tura " + Skills.WORDPRESS);

            } else {
                System.out.println("========== GRA SIĘ KONCZY");
                ingame = false;
            }






        }
    }
}
