package solver;

public class LinearMatrix {
    public double[] calculateMatrix(double[][] linearMatrix) {
        double m;
        for (int k = 1; k < linearMatrix.length; k++) {
            for (int j = k; j < linearMatrix.length; j++) {
                m = linearMatrix[j][k - 1] / linearMatrix[k - 1][k - 1];
                for (int i = 0; i < linearMatrix.length + 1; i++) {
                    linearMatrix[j][i] -= m * linearMatrix[k - 1][i];
                }
            }
        }
        double[] result = new double[linearMatrix.length];
        for (int i = linearMatrix.length - 1; i >= 0; i--) {
            result[i] = linearMatrix[i][linearMatrix.length] / linearMatrix[i][i];
            for (int c = linearMatrix.length - 1; c > i; c--) {
                result[i] -= linearMatrix[i][c] * result[c] / linearMatrix[i][i];
            }
        }
        return result;
    }
}
