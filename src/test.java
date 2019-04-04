public class test {
    public static void main(String[] args) {
        Matrix m1 = new Matrix();
        m1.fillMatrix();
        Matrix m2 = new Matrix();
        m2.fillMatrix();
        Matrix m3 = new Matrix();
        m3.fillMatrix();
        Matrix m4 = new Matrix();
        m4.fillMatrix();
        Matrix m5 = m1.addMatrices(m1, m2, m3, m4);
        //m1.setAt(m1.getMatrix(), 12, 2,2);
        m5.printMatrix();
    }
}
