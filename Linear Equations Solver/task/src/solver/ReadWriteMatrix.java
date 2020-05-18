package solver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadWriteMatrix {
    public double[][] readMatrix(String importPath) {
        double[][] result = new double[0][];
        try (final Scanner scanner = new Scanner(new File(importPath))) {
            while (scanner.hasNext()) {
                int size = scanner.nextInt();
                result = new double[size][size];
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size + 1; j++) {
                        result[i][j] = scanner.nextDouble();
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        return result;
    }
    public void  saveMatrix(String exportPath, double[] matrixForSave) {
        File file = new File(exportPath);
        try (var writer = new FileWriter(file)){
            for (double v : matrixForSave) {
                writer.write(v + "\n");
            }
        } catch (IOException e){
            System.out.println("Error while writing file");
        }
    }
}
