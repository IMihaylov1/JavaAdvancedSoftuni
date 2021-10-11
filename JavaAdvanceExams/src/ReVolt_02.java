import java.util.Scanner;

public class ReVolt_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int commandsCount = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < matrix.length; row++) {
            String lineRow = scanner.nextLine();
            matrix[row] = lineRow.toCharArray();
        }
        int playerRow = 0;
        int playerCol = 0;

//        FINDING PLAYER POSITION IN THE MATRIX!!
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                char currentPosition = matrix[row][col];
                if (currentPosition == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    int nextStepUp = playerRow - 1;
                    if (nextStepUp < 0) {
                        nextStepUp = matrix.length - 1;
                    }
                    if (matrix[nextStepUp][playerCol] == '-') {
                        matrix[nextStepUp][playerCol] = 'f';
                        matrix[playerRow][playerCol] = '-';
                        playerRow = nextStepUp;
                    } else if (matrix[nextStepUp][playerCol] == 'B') {
                        nextStepUp = nextStepUp - 1;
                        matrix[nextStepUp][playerCol] = 'f';
                        matrix[playerRow][playerCol] = '-';
                        playerRow = nextStepUp;
                    } else if (matrix[nextStepUp][playerCol] == 'F') {
                        matrix[nextStepUp][playerCol] = 'f';
                        matrix[playerRow][playerCol] = '-';
                        System.out.println("Player won!");
                        printMatrix(matrix);
                        return;
                    }
            break;
            case "down":
                int nextStepDown = playerRow + 1;
                if (nextStepDown > matrix.length - 1) {
                    nextStepDown = 0;

                }
                if (matrix[nextStepDown][playerCol] == '-') {
                    matrix[nextStepDown][playerCol] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerRow = nextStepDown;
                } else if (matrix[nextStepDown][playerCol] == 'B') {
                    nextStepDown = nextStepDown + 1;
                    matrix[nextStepDown][playerCol] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerRow = nextStepDown;
                } else if (matrix[nextStepDown][playerCol] == 'F') {
                    matrix[nextStepDown][playerCol] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    System.out.println("Player won!");
                    printMatrix(matrix);
                    return;
                }
                break;
            case "left":
                int nextStepLeft = playerCol - 1;
                if (nextStepLeft < 0) {
                    nextStepLeft = matrix.length - 1;

                }
                if (matrix[playerRow][nextStepLeft] == '-') {
                    matrix[playerRow][nextStepLeft] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerCol = nextStepLeft;
                } else if (matrix[playerRow][nextStepLeft] == 'B') {
                    nextStepLeft = nextStepLeft - 1;
                    matrix[playerRow][nextStepLeft] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerCol = nextStepLeft;
                } else if (matrix[playerRow][nextStepLeft] == 'F') {
                    matrix[playerRow][nextStepLeft] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    System.out.println("Player won!");
                    printMatrix(matrix);
                    return;
                }


                break;
            case "right":
                int nextStepRight = playerCol + 1;
                if (nextStepRight > matrix.length - 1) {
                    nextStepRight = 0;
                }
                if (matrix[playerRow][nextStepRight] == '-') {
                    matrix[playerRow][nextStepRight] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerCol = nextStepRight;
                } else if (matrix[playerRow][nextStepRight] == 'B') {
                    nextStepRight = nextStepRight + 1;
                    matrix[playerRow][nextStepRight] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    playerCol = nextStepRight;
                } else if (matrix[playerRow][nextStepRight] == 'F') {
                    matrix[playerRow][nextStepRight] = 'f';
                    matrix[playerRow][playerCol] = '-';
                    System.out.println("Player won!");
                    printMatrix(matrix);
                    return;
                }
                break;
        }
    }
        System.out.println("Player lost!");

    printMatrix(matrix);


}

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            System.out.println(chars);
        }
    }

}
