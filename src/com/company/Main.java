package com.company;

import java.util.Scanner;

public class Main {
    static void printMenu(int printOption){
        switch(printOption){
            case 1 :
                System.out.println("Welcome to Backpack\n" +
                "1. Enter as instructor\n" +
                "2. Enter as student\n" +
                "3. Exit\n");
                break;
            case 2 :
                System.out.println("");
        }
    }

    static void studentMenu (){

    }
    static void instructorMenu (){

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean backPackOption = true;
        while (backPackOption){
            printMenu(1);
	        int menuOption = scan.nextInt();
            switch(menuOption) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    instructorMenu();
                case 3:
                    backPackOption = false;
                    break;
                default:
                    System.out.println("Please enter the correct value for the menu");
                }
            }
    }
}
