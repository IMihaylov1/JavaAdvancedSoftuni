import java.util.Scanner;

public class BookWorm_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String printEnd = scanner.nextLine();

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
        }
        int playerRow = -1;
        int playerCol = -1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                char currentPosition = matrix[row][col];
                if (currentPosition == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }


        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    int nextStepUp = playerRow - 1;
                    if (isOutOfBound(matrix, nextStepUp, playerCol)) {
                        if (printEnd.length() >= 1) {
                            printEnd = printEnd.substring(0,printEnd.length()-1);
                        }

                    } else {
                        if (matrix[nextStepUp][playerCol] != '-') {
                            printEnd += matrix[nextStepUp][playerCol];
                            matrix[nextStepUp][playerCol] = 'P';
                            matrix[playerRow][playerCol]='-';
                        } else {
                            matrix[nextStepUp][playerCol] = 'P';
                            matrix[playerRow][playerCol] = '-';
                        }
                        playerRow = nextStepUp;
                    }

                    break;
                case "down":
                    int nextStepDown = playerRow + 1;
                    if (isOutOfBound(matrix, nextStepDown, playerCol)) {
                        if (printEnd.length() >= 1) {
                            printEnd = printEnd.substring(0,printEnd.length()-1);
                        }

                    } else {
                        if (matrix[nextStepDown][playerCol] != '-') {
                            printEnd += matrix[nextStepDown][playerCol];
                            matrix[nextStepDown][playerCol] = 'P';
                            matrix[playerRow][playerCol]='-';

                        } else {
                            matrix[nextStepDown][playerCol] = 'P';
                            matrix[playerRow][playerCol] = '-';
                        }
                        playerRow = nextStepDown;
                    }
                    break;
                case "left":
                    int nextStepLeft = playerCol - 1;
                    if (isOutOfBound(matrix, playerRow, nextStepLeft)) {
                        if (printEnd.length() >= 1) {
                            printEnd = printEnd.substring(0,printEnd.length()-1);
                        }

                    } else {
                        if (matrix[playerRow][nextStepLeft] != '-') {
                            printEnd += matrix[playerRow][nextStepLeft];
                            matrix[playerRow][nextStepLeft] = 'P';
                            matrix[playerRow][playerCol]='-';
                        } else {
                            matrix[playerRow][nextStepLeft] = 'P';
                            matrix[playerRow][playerCol] = '-';
                        }
                        playerCol = nextStepLeft;
                    }
                    break;
                case "right":
                    int nextStepRight = playerCol + 1;
                    if (isOutOfBound(matrix, playerRow, nextStepRight)) {
                        if (printEnd.length() >= 1) {
                            printEnd = printEnd.substring(0,printEnd.length()-1);

                        }

                    } else {
                        if (matrix[playerRow][nextStepRight] != '-') {
                            printEnd += matrix[playerRow][nextStepRight];
                            matrix[playerRow][nextStepRight] = 'P';
                            matrix[playerRow][playerCol]='-';
                        } else {
                            matrix[playerRow][nextStepRight] = 'P';
                            matrix[playerRow][playerCol] = '-';
                        }
                        playerCol = nextStepRight;
                    }
                    break;
            }


            command = scanner.nextLine();
        }
        System.out.println(printEnd);
        printMatrix(matrix);

    }

    public static boolean isOutOfBound(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
