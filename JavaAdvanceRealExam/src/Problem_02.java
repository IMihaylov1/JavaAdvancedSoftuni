import java.util.Arrays;
import java.util.Scanner;

public class Problem_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] task = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = task[0];
        int m = task[1];

        int matrix[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("Bloom Bloom Plow")) {
            String[] tokens = input.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            if (isOutOfBound(matrix, row, col)) {
                System.out.println("Invalid coordinates.");
                continue;
            } else {
                int rowUp = row;
                while (rowUp >= 0) {
                        matrix[rowUp][col] += 1;
                        rowUp--;
                    }

                int rowDown = row+1;
                while (rowDown <= matrix.length-1 ) {
                        matrix[rowDown][col] += 1;
                        rowDown++;
                    }
                int colLeft = col-1;
                while (colLeft >= 0) {
                        matrix[row][colLeft] += 1;
                        colLeft--;
                }
                int colRight = col+1;
                while (colRight <= matrix.length-1) {
                        matrix[row][colRight] += 1;
                        colRight++;
                }

            }


            input = scanner.nextLine();


        }
        printMatrix(matrix);

    }

    public static boolean isOutOfBound(int[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
