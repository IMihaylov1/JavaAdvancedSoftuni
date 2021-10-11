import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstMatrixRows = dimension[0];
        int firstMatrixCols = dimension[1];
        int [] [] firstMatrix = new int[firstMatrixRows][];

        for (int i = 0; i <firstMatrixRows ; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            firstMatrix[i] = arr;
        }
        dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int secondMatrixRows = dimension[0];
        int secondMatrixCols = dimension[1];
        int [] [] secondMatrix = new int[secondMatrixRows][];

        for (int i = 0; i <secondMatrixRows ; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            secondMatrix[i] = arr;
        }

        if(firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length){
            System.out.println("not equal");
            return;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {

                if(firstMatrix[row][col] != secondMatrix[row][col]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");


    }


}
