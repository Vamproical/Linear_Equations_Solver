package solver;
public class Main {
    public static void main(String[] args) {
        String readPath = "";
        String writePath = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-in")) {
                readPath = args[i + 1];
            }
            if  (args[i].equals("-out")) {
                writePath = args[i + 1];
            }
        }
        ReadWriteMatrix readWriteMatrix = new ReadWriteMatrix();
        double[][] incomeMatrix = readWriteMatrix.readMatrix(readPath);
        LinearMatrix linearMatrix = new LinearMatrix();
        double[] resultMatrix = linearMatrix.calculateMatrix(incomeMatrix);
        readWriteMatrix.saveMatrix(writePath,resultMatrix);
    }
}
