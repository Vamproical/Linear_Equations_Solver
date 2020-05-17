package solver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        double[][] linearMatrix = new double[size][size+1];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                linearMatrix[i][j] = scanner.nextInt();
            }
        }
        double m;
        for (int k = 1; k < size; k++) {
            for (int j = k; j < size; j++) {
                m = linearMatrix[j][k - 1] / linearMatrix[k-1][k-1];
                for (int i = 0; i < size + 1; i++) {
                    linearMatrix[j][i] -= m * linearMatrix[k - 1][i];
                }
            }
        }
        double[] result = new double[size];
        for (int i = size - 1; i >= 0; i--) {
            result[i] = linearMatrix[i][size] / linearMatrix[i][i];
            for (int c = size - 1; c > i; c--) {
                result[i] -= linearMatrix[i][c] * result[c] / linearMatrix[i][i];
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(result[i]);
        }
    }
}
