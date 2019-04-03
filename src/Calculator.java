//Done for #100DaysOfCode

public class Calculator {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(3,3);
        Matrix m2 = new Matrix(3,3);
        Matrix m3 = new Matrix(3,3);
        int a[][] = {{1,1,1},{1,1,1},{1,1,1}};
        m1.setMatrix(a);
        m2.setMatrix(a);
        m3.setMatrix(a);
        m1.addMatrices(m2, m3);
        m1.printMatrix();



    }
}
