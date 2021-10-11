import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = input;
        }

        int sum = getSumDiagonalFromTopLeftToBottom(matrix);
        int secondSum = getSumDiagonalFromTopRightToBottom(matrix);
        System.out.println(Math.abs(sum-secondSum));


//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//
//                System.out.print(matrix[row][col] + " ");
//            }
//            System.out.println();
//        }
    }

    private static int getSumDiagonalFromTopRightToBottom(int[][] matrix) {
        int row = 0;
        int col = matrix.length-1;
        int sum = 0;

        while (row < matrix.length && col >= 0){
            int currentNum = matrix[row][col];
            sum+=currentNum;
            row++;
            col --;

        }
        return (sum);
    }

    private static int getSumDiagonalFromTopLeftToBottom(int[][] matrix) {
        int row = 0;
        int col = 0;

        int sum = 0;
        while (row < matrix.length && col < matrix.length) {

            int currentNum = (matrix[row][col]);
            sum += currentNum;
            row++;
            col++;

        }
        return (sum);
    }

}
