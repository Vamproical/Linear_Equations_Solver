package solver;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String readPath = "";
        String writePath = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-in")) {
                readPath = args[i++];
            }
            if  (args[i].equals("-out")) {
                writePath = args[i++];
            }
        }
        ReadWriteMatrix readWriteMatrix = new ReadWriteMatrix();
        double[][] incomeMatrix = readWriteMatrix.readMatrix(readPath);
        LinearMatrix linearMatrix = new LinearMatrix();
        double[] resultMatrix = linearMatrix.calculateMatrix(incomeMatrix);
        readWriteMatrix.saveMatrix(writePath,resultMatrix);
    }
}
