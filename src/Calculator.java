//Done for #100DaysOfCode
/**
 * @author LunarCultist
 *
 * This is the main class of the MCalc application. It contains the implementation of the user interface. Actually its
 * only a console user interface, but I am gonna add a nice swing interface later.
 * At this time, the application only works for natural number scalars, for some reasons. But late, I will also implement
 * reel numbers.
 * It's just a project for fun, so I actually don't plan a feature for complex numbers. That's what for instance Octave
 * is made for.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    private static Scanner scanner = new Scanner(System.in);
    private static String operation;
    private static List<Matrix> MatrixList = new ArrayList<>();

    private static void showMenu(){
        //System.out.print("\033[H\033[2J");                                     //actually commented for better control
        //System.out.flush();
        System.out.println("Welcome to MCalc\n" +
                "Choose an operation from menu:\n\n" +
                "1 - Show Memory\n" +
                "2 - Insert Matrix\n" +
                "3 - Delete Matrix\n" +
                "4 - Add Matrices\n" +
                "5 - Multiply Matrices\n" +
                "6 - Exit\n\n");
        operation = scanner.next();
    }

    private static void insertMatrix(){
        System.out.println("How many matrices do you wanna insert?");
        int number = scanner.nextInt();         //verify, that the input is correct with try catch for error in for-loop
        for(int i = 0; i < number; i++){
            Matrix m = new Matrix();
            m.fillMatrix();
            MatrixList.add(m);
            m.printMatrix();
            System.out.println("was added");
        }
    }

    private static void showMemory(){
        if(MatrixList.toArray().length == 0){
            System.out.println("Memory contains no entries!");
        }
        else{
            for(int i = 0; i < MatrixList.toArray().length; i++){
                System.out.println("M" + i + " :");
                MatrixList.get(i).printMatrix();
                System.out.println();
            }
        }
    }

    private static void addition(){
        //actually only for adding 2 matrices
        int a;
        int b;
        System.out.println("Choose a matrix  A  for adding:");
        a = scanner.nextInt();                                                      //implement checking for right input
        System.out.println("Choose a matrix B for adding to Matrix A:");
        b = scanner.nextInt();                                                      //implement checking for right input
        Matrix matA = MatrixList.get(a);
        Matrix matB = MatrixList.get(b);
        Matrix c = matA.addMatrices(matB);
        MatrixList.add(c);
        c.printMatrix();
        System.out.println("was added to matrix list at position -> M" + MatrixList.indexOf(c) + " into memory");
    }

    private static void multiplication(){
        //actually only for multiplying 2 matrices
        int a;
        int b;
        System.out.println("Choose a matrix A for multiplying:");
        a = scanner.nextInt();                                      //implement checking of right input
        System.out.println("Choose a matrix B you wanna multiply with A:");
        b = scanner.nextInt();
        Matrix matA = MatrixList.get(a);
        Matrix matB = MatrixList.get(b);
        Matrix c = matA.multiplyMatrices(matB);
        MatrixList.add(c);
        c.printMatrix();
        System.out.println("was added to matrix list at position -> M" + MatrixList.indexOf(c) + " into memory ");
    }

    private static void deleteMatrix(){
        int a;
        String sure;
        Matrix c;
        System.out.println("Which matrix do you wanna delete (position required):");
        a = scanner.nextInt();        //check for correct input
        System.out.println("Do you really wanna remove matrix M" + a + " from memory? (y/N)");
        sure = scanner.next();
        switch (sure){
            case "y":
                c = MatrixList.get(a);
                MatrixList.remove(a);
                c.printMatrix();
                System.out.println("was removed from memory");
                break;
            case "Y":
                c = MatrixList.get(a);
                MatrixList.remove(a);
                c.printMatrix();
                System.out.println("was removed from memory");
            default:
                break;
        }
    }

    public static void main(String[] args) {
        while(1>0){                                             //infinity loop for always coming back to the main menu
            showMenu();
            switch(operation){                                  //really need to implement type test for every input, that no error or exception appears while using the UI
                case "1":
                    showMemory();
                    break;
                case "2":
                    insertMatrix();
                    break;
                case "3":
                    deleteMatrix();
                    break;
                case "4":
                    addition();
                    break;
                case "5":
                    multiplication();
                    break;
                case "6":
                    System.exit(0);
                default:
                    System.out.println("Wrong input!");
                    break;
            }
        }
    }
}