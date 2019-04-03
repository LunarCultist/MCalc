//Done for #100DaysOfCode

import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);
    private static String operation;

    static void showMenu(){
        System.out.println("Welcome to MCalc\n" +
                "Choose an operation from menu:\n\n" +
                "1 - Add Matrices\n" +
                "2 - Multiply Matrices\n" +
                "3 - Exit\n\n");
        operation = scanner.next();
    }

    public static void main(String[] args) {
        showMenu();
        switch(operation){
            case "1":
                //TO-DO
                showMenu();
                break;
            case "2":
                //TO-DO
                showMenu();
                break;
            case "3":
                System.exit(0);
                break;

                default:
                    System.out.println("Wrong input!");
                    break;
        }


    }
}
