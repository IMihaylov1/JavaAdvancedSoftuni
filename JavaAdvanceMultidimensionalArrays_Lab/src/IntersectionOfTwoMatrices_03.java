
import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        int multiply = rows * 2;
        rows = multiply / 2;


        String[][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                firstMatrix[row][col] = input[col];
            }
        }
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                secondMatrix[row][col] = input[col];
            }
        }

        String[][] thirdMatrix = new String[rows][cols];
        String element = "*";

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    thirdMatrix[row][col] = firstMatrix[row][col];
                } else {
                    thirdMatrix[row][col] = element;
                }
            }
        }
//         Принтиране на матрица

//        for (String[] matrix : thirdMatrix) {
//            for (String s : matrix) {
//                System.out.print(s + " ");
//            }
//            System.out.println();
//        }

//        Алтернативно принтира на матрица
        for (int row = 0; row < thirdMatrix.length; row++) {
            for (int col = 0; col < thirdMatrix[row].length; col++) {
                System.out.print(thirdMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
