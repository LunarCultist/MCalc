//Done for #100DaysOfCode

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);
    private static String operation;
    private static List<Matrix> MatrixList = new ArrayList<>();

    private static void showMenu(){
        //System.out.print("\033[H\033[2J");   //actually commented for better controll
        //System.out.flush();
        System.out.println("Welcome to MCalc\n" +
                "Choose an operation from menu:\n\n" +
                "1 - Show Memory\n" +
                "2 - Insert Matrix\n" +
                "3 - Add Matrices\n" +
                "4 - Multiply Matrices\n" +
                "5 - Exit\n\n");
        operation = scanner.next();
    }

    private static void insertMatrix(){  //create an arraylist -> dynamic with all created matrices for better comfort
        System.out.println("How many matrices do you wanna insert?");
        int number = scanner.nextInt();   //verify that the input is correct with try catch for error in for-loop
        for(int i = 0; i < number; i++){
            Matrix m = new Matrix();
            m.fillMatrix();
            MatrixList.add(m);
        }
    }


    public static void main(String[] args) {
            showMenu();
            switch(operation){
                case "1":
                    //showMemory();    //print the array list with matrices and names
                    showMenu();
                    break;
                case "2":
                    insertMatrix();
                    showMenu();
                    break;
                case "3":
                    //TO-DO
                    showMenu();
                    break;
                case "4":
                    //TO-DO
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Wrong input!");
                    break;
            }

    }
}
