import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = input[0];
        int cols = input[1];
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int maxSum = Integer.MIN_VALUE;
        int indexRow = 0;
        int indexCol = 0;


        for (int row = 1; row < rows - 1; row++) {
            for (int col = 1; col < cols - 1; col++) {
                int sum = calculateMatrixSum(matrix, row, col);
                if (sum > maxSum) {
                    maxSum = sum;
                    indexRow = row;
                    indexCol = col;

                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMaxMatrixFromALlMatrixs(matrix, indexRow, indexCol);
    }

    private static void printMaxMatrixFromALlMatrixs(int[][] matrix, int indexRow, int indexCol) {

        for (int row = indexRow - 1; row <= indexRow + 1; row++) {
            for (int col = indexCol - 1; col <= indexCol + 1; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static int calculateMatrixSum(int[][] matrix, int row, int col) {
        int sum = 0;

        sum += matrix[row][col];
        // Right
        sum += matrix[row][col + 1];
        //Left
        sum += matrix[row][col - 1];
        //Up
        sum += matrix[row - 1][col];
        //Down
        sum += matrix[row + 1][col];
        //RightUp
        sum += matrix[row - 1][col + 1];
        //LeftUp
        sum += matrix[row - 1][col - 1];
        //RightDown
        sum += matrix[row + 1][col + 1];
        //LeftDown
        sum += matrix[row + 1][col - 1];
        return sum;
    }
}
