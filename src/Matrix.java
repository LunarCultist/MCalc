//Done for #100DaysOfCode
import java.util.Scanner;

public class Matrix {

    private int y_value;
    private int x_value;
    private boolean filled = false;
    private int[][] matrix;


    public void fillMatrix(){
        Scanner scanner = new Scanner(System.in);
        int temp;
        for(int i = 0 ; i < this.y_value ; i++){
            for(int j = 0 ; j < this.x_value ; j++){
                System.out.println("Value at position " + "(" + (j+1) + " | " + (i+1) + ") = ?");
                temp = scanner.nextInt();
                this.matrix[j][i] = temp;
            }
        }
        this.setFilled(true);
        System.out.println("");
    }


    public void setMatrix(int[][] a){    //{{first line}, {second line}, {third line}}
        if(a.length == this.x_value && a[0].length == this.y_value){
            for(int i = 0 ; i < a.length ; i++){
                for(int j = 0 ; j < a[0].length ; j++){
                    this.matrix[j][i] = a[i][j];
                }
            }
        }
        else{
            throw new IllegalArgumentException("Size of insertion and size of the matrix are not the same!");
        }
    }

    public void printMatrix(){
        for(int i = 0; i < this.y_value ; i++){  //print line-wise
            for(int j = 0; j < this.x_value; j++){
                System.out.print(" ");
                System.out.print(this.matrix[j][i]);
                System.out.print(" ");
            }
            System.out.println("\n");  //new line
        }
        System.out.println("\n");
    }

    public Matrix addMatrices(Matrix b){   //add a second matrix b to the actual Matrix object
        /*
        implement a second Method for more than one matrix in the parameter list
        addMatrices(Matrix b ...)
         */
        if(this.getX_value() != b.getX_value() || this.getY_value() != b.getY_value()) {
            throw new IllegalArgumentException("dimensions are different. Not addable");
        }
        Matrix c = new Matrix(this.getY_value(), b.getX_value());
        for(int i = 0; i < this.getY_value(); i++){
            for(int j = 0; j < b.getX_value(); j++){
                c.getMatrix()[j][i] = (this.getMatrix()[j][i] + b.getMatrix()[j][i]);
            }
        }
        return c;
    }

    public Matrix addMatrices(Matrix ...b){  //actual problem: size of b doesnt decrease
        /*
        The problem is, that an array is a static data structure of course. So i can not change the size after
        declaration.
        So instead of using the old array b, I have to create a new one in every run

        I will create a new Array temp after each run and fill if with one place less than in the run before
         */

        Matrix x = new Matrix();
        while(b.length > 1){
            System.out.println(b.length);
            x.setMatrix(b[0].addMatrices(b[1]).getMatrix());
            int h = 0;
            Matrix[] temp = new Matrix[b.length-1];
            for(int i = 2; i<b.length; i++){   //for loop isnt called
                b[h] = temp[i];
            }

            for(Matrix z:b){   //testing
                z.printMatrix();
            }
            addMatrices(temp);
        }
        return x;
    }

    private int getValue ( int[][] aArray, int[][] bArray, int x, int y){  //helping method; multiplies x raw of A and y column scalarwise
        int result = 0;  //else compiler says: might not be initialized...
        int c = 0;
        int d = 0;
        while (c < aArray.length) {
            result += (aArray[c][y] * bArray[x][d]);
            c++;
            d++;
        }

        return result;
    }


    public Matrix multiplyMatrices(Matrix b) {

        if(this.x_value != b.getY_value()){   //number of columns of A and number of rows in B must be the same value
            throw new IllegalArgumentException("Multiplication is not defined for these two matrices");
        }
        Matrix c = new Matrix(this.y_value, b.getX_value()); //matrix c with dimensions from A and B
        int temp = 0; //scalar temp variable
        for(int i = 0; i < c.getY_value(); i++){
            for(int j = 0; j < c.getX_value(); j++){
                c.getMatrix()[j][i] = getValue(this.getMatrix(), b.getMatrix(), j,i);
            }
        }
        return c;
    }

    //setter and getter methods

    public int[][] getMatrix(){
        return this.matrix;
    }

    public int getY_value() {
        return y_value;
    }

    public void setY_value(int y_value) {
        this.y_value = y_value;
    }

    public int getX_value() {
        return x_value;
    }

    public void setX_value(int x_value) {
        this.x_value = x_value;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    //end of setter and getter methods


    public Matrix(int y_value, int x_value) {  //first hight second width
        this.y_value = y_value;
        this.x_value = x_value;
        matrix = new int[x_value][y_value];
    }

    public Matrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hight of the matrix?");
        this.y_value = scanner.nextInt();
        System.out.println("Width of the matrix?");
        this.x_value = scanner.nextInt();
        matrix = new int[x_value][y_value];
    }
}
