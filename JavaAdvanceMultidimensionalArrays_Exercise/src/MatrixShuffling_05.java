import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = input[0];
        int cols = input[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }

        String[] commands = scanner.nextLine().split("\\s+");
        while (!commands[0].equals("END")) {
            if (commands.length > 5) {
                System.out.println("Invalid input!");
                commands = scanner.nextLine().split("\\s+");
                continue;
            }
            if (commands[0].equals("swap")) {
                int row1 = Integer.parseInt(commands[1]);
                int col1 = Integer.parseInt(commands[2]);
                int row2 = Integer.parseInt(commands[3]);
                int col2 = Integer.parseInt(commands[4]);
                if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
                    System.out.println("Invalid input!");
                    commands = scanner.nextLine().split("\\s+");

                    continue;
                } else {
                    String element = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = element;
                    for (int r = 0; r < matrix.length; r++) {
                        for (int c = 0; c < matrix[r].length; c++) {
                            System.out.print(matrix[r][c] + " ");
                        }
                        System.out.println();
                    }
                }

            } else {
                System.out.println("Invalid input!");
            }
            commands = scanner.nextLine().split("\\s+");
        }
    }
}
