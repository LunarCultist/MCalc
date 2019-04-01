//Done for #100DaysOfCode

public class Calculator {
    public static void main(String[] args) {
        Matrix m1 = new Matrix();
        Matrix m2 = new Matrix();
        m1.fillMatrix();
        m2.fillMatrix();
        m1.printMatrix();
        m2.printMatrix();
        Matrix m3 = m1.addMatrices(m2);
        m3.printMatrix();
    }
}
