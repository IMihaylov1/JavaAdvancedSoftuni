import java.util.Scanner;

public class Snake_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }
        int snakeRow = 0;
        int snakeCol = 0;
        int count = 0;
        int firstTrapRow = 0;
        int firstTrapCol = 0;

        int secondTrapRow = 0;
        int secondTrapCol = 0;

        int foodQuantity = 0;
        int countTraps = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                char currentPosition = matrix[row][col];
                if (currentPosition == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                } else if (currentPosition == 'B') {
                    if (count == 0) {
                        firstTrapRow = row;
                        firstTrapCol = col;
                        count++;
                        countTraps++;
                    } else {
                        secondTrapRow = row;
                        secondTrapCol = col;
                    }
                }
            }
        }
        if (countTraps != 0) {

            matrix[secondTrapRow][secondTrapCol] = 'b';
        }

        while (foodQuantity != 10) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    int nextStepUp = snakeRow - 1;
                    if (isOutOfBound(matrix, nextStepUp, snakeCol)) {
                        matrix[snakeRow][snakeCol] = '.';
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", foodQuantity);
                        printMatrix(matrix);
                        return;
                    } else {
                        if (matrix[nextStepUp][snakeCol] == '-') {
                            matrix[nextStepUp][snakeCol] = 'S';
                            matrix[snakeRow][snakeCol] = '.';
                            snakeRow = nextStepUp;

                        } else if (matrix[nextStepUp][snakeCol] == '*') {
                            matrix[nextStepUp][snakeCol] = 'S';
                            matrix[snakeRow][snakeCol] = '.';
                            snakeRow = nextStepUp;
                            foodQuantity++;
                        } else if (matrix[nextStepUp][snakeCol] == 'B') {
                            matrix[nextStepUp][snakeCol] = '.';
                            matrix[snakeRow][snakeCol] = '.';
                            matrix[secondTrapRow][secondTrapCol] = 'S';
                            snakeRow = secondTrapRow;
                            snakeCol = secondTrapCol;
                        } else if (matrix[nextStepUp][snakeCol] == 'b') {
                            matrix[nextStepUp][snakeCol] = '.';
                            matrix[snakeRow][snakeCol] = '.';
                            matrix[firstTrapRow][firstTrapCol] = 'S';
                            snakeRow = firstTrapRow;
                            snakeCol = firstTrapCol;
                        }
                    }
                    break;
                case "down":
                    int nextStepDown = snakeRow + 1;
                    if (isOutOfBound(matrix, nextStepDown, snakeCol)) {
                        matrix[snakeRow][snakeCol] = '.';
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", foodQuantity);
                        printMatrix(matrix);
                        return;
                    } else {
                        if (matrix[nextStepDown][snakeCol] == '-') {
                            matrix[nextStepDown][snakeCol] = 'S';
                            matrix[snakeRow][snakeCol] = '.';
                            snakeRow = nextStepDown;

                        } else if (matrix[nextStepDown][snakeCol] == '*') {
                            matrix[nextStepDown][snakeCol] = 'S';
                            matrix[snakeRow][snakeCol] = '.';
                            snakeRow = nextStepDown;
                            foodQuantity++;
                        } else if (matrix[nextStepDown][snakeCol] == 'B') {
                            matrix[nextStepDown][snakeCol] = '.';
                            matrix[snakeRow][snakeCol] = '.';
                            matrix[secondTrapRow][secondTrapCol] = 'S';
                            snakeRow = secondTrapRow;
                            snakeCol = secondTrapCol;
                        } else if (matrix[nextStepDown][snakeCol] == 'b') {
                            matrix[nextStepDown][snakeCol] = '.';
                            matrix[snakeRow][snakeCol] = '.';
                            matrix[firstTrapRow][firstTrapCol] = 'S';
                            snakeRow = firstTrapRow;
                            snakeCol = firstTrapCol;
                        }
                    }
                    break;
                case "left":
                    int nextStepLeft = snakeCol - 1;
                    if (isOutOfBound(matrix, snakeRow, nextStepLeft)) {
                        matrix[snakeRow][snakeCol] = '.';
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", foodQuantity);
                        printMatrix(matrix);
                        return;
                    } else {
                        if (matrix[snakeRow][nextStepLeft] == '-') {
                            matrix[snakeRow][nextStepLeft] = 'S';
                            matrix[snakeRow][snakeCol] = '.';
                            snakeCol = nextStepLeft;

                        } else if (matrix[snakeRow][nextStepLeft] == '*') {
                            matrix[snakeRow][nextStepLeft] = 'S';
                            matrix[snakeRow][snakeCol] = '.';
                            snakeCol = nextStepLeft;
                            foodQuantity++;
                        } else if (matrix[snakeRow][nextStepLeft] == 'B') {
                            matrix[snakeRow][nextStepLeft] = '.';
                            matrix[snakeRow][snakeCol] = '.';
                            matrix[secondTrapRow][secondTrapCol] = 'S';
                            snakeRow = secondTrapRow;
                            snakeCol = secondTrapCol;
                        } else if (matrix[snakeRow][nextStepLeft] == 'b') {
                            matrix[snakeRow][nextStepLeft] = '.';
                            matrix[snakeRow][snakeCol] = '.';
                            matrix[firstTrapRow][firstTrapCol] = 'S';
                            snakeRow = firstTrapRow;
                            snakeCol = firstTrapCol;
                        }
                    }
                    break;
                case "right":
                    int nextStepRight = snakeCol + 1;
                    if (isOutOfBound(matrix, snakeRow, nextStepRight)) {
                        matrix[snakeRow][snakeCol] = '.';
                        System.out.println("Game over!");
                        System.out.printf("Food eaten: %d%n", foodQuantity);
                        printMatrix(matrix);
                        return;
                    } else {
                        if (matrix[snakeRow][nextStepRight] == '-') {
                            matrix[snakeRow][nextStepRight] = 'S';
                            matrix[snakeRow][snakeCol] = '.';
                            snakeCol = nextStepRight;

                        } else if (matrix[snakeRow][nextStepRight] == '*') {
                            matrix[snakeRow][nextStepRight] = 'S';
                            matrix[snakeRow][snakeCol] = '.';
                            snakeCol = nextStepRight;
                            foodQuantity++;
                        } else if (matrix[snakeRow][nextStepRight] == 'B') {
                            matrix[snakeRow][nextStepRight] = '.';
                            matrix[snakeRow][snakeCol] = '.';
                            matrix[secondTrapRow][secondTrapCol] = 'S';
                            snakeRow = secondTrapRow;
                            snakeCol = secondTrapCol;
                        } else if (matrix[snakeRow][nextStepRight] == 'b') {
                            matrix[snakeRow][nextStepRight] = '.';
                            matrix[snakeRow][snakeCol] = '.';
                            matrix[firstTrapRow][firstTrapCol] = 'S';
                            snakeRow = firstTrapRow;
                            snakeCol = firstTrapCol;
                        }
                    }
                    break;
            }
        }


        System.out.println("You won! You fed the snake.");
        System.out.printf("Food eaten: %d%n", foodQuantity);
        printMatrix(matrix);


    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isOutOfBound(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
