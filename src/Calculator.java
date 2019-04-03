//Done for #100DaysOfCode

public class Calculator {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(2,2);
        Matrix m2 = new Matrix(2,2);
        Matrix m3 = new Matrix(2,2);
        m1.fillMatrix();
        m2.fillMatrix();
        m3.fillMatrix();
        m1.addMatrices(m2, m3);
        m1.printMatrix();



    }
}
