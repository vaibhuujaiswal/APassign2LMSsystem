package com.company;

import java.util.Scanner;

public class Main {
    static void printMenu(int printOption){
        switch(printOption){
            case 1 :
                System.out.println("Welcome to Backpack\n" +
                        "1. Enter as instructor\n" +
                        "2. Enter as student\n" +
                        "3. Exit");
                break;
            case 2 :
                System.out.println("INSTRUCTOR MENU\n" +
                        "1. Add class material\n" +
                        "2. Add assessments\n" +
                        "3. View lecture materials\n" +
                        "4. View assessments\n" +
                        "5. Grade assessments\n" +
                        "6. Close assessment\n" +
                        "7. View comments\n" +
                        "8. Add comments\n" +
                        "9. Logout");
                break;
            case 3:
                System.out.println("STUDENT MENU\n" +
                        "1. View lecture materials\n" +
                        "2. View assessments\n" +
                        "3. Submit assessment\n" +
                        "4. View grades\n" +
                        "5. View comments\n" +
                        "6. Add comments\n" +
                        "7. Logout");
                break;
        }
    }

    static void studentMenu (){
        boolean studentCondition = true;
        while(studentCondition){

        }

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
                    instructorMenu();
                    break;
                case 2:
                    studentMenu();
                    break;
                case 3:
                    backPackOption = false;
                    break;
                default:
                    System.out.println("Please enter the correct value for the menu!");
                }
            }
    }
}
