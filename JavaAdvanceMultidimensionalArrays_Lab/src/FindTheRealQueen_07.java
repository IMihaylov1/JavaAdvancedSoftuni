import java.util.Scanner;

public class FindTheRealQueen_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 8;
        char[][] matrix = new char[size][size];


        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            String strippedString = line.replaceAll("\\s+", "");
            matrix[row] = strippedString.toCharArray();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q') {
                    boolean isColValid = checkIfQueenCol(matrix, col);
                    boolean isRowValid = checkIfQueenRow(matrix, row);
                    boolean isMainDiagonalUpLeft = checkMainDiagonalUpLeft(matrix, row, col);
                    boolean isMainDiagonalDownRight = checkMainDiagonalDownRight(matrix, row, col);
                    boolean isMainDiagonalDownLeft = checkMainDiagonalDownLeft(matrix, row, col);
                    boolean isMainDiagonalUpRight = checkMainDiagonalUpRight(matrix, row, col);
                    if (isColValid && isRowValid && isMainDiagonalUpLeft && isMainDiagonalDownRight
                            && isMainDiagonalDownLeft && isMainDiagonalUpRight) {
                        System.out.println(row + " " + col);
                       return;
                    }
                }
            }
        }
    }

    private static boolean checkMainDiagonalDownLeft(char[][] matrix, int row, int col) {
        row++;
        col--;
        while (row < matrix.length && col >= 0) {
            if (matrix[row++][col--] == 'q') {
                return false;
            }
        }
        return true;

    }

    private static boolean checkMainDiagonalDownRight(char[][] matrix, int row, int col) {

        row++;
        col++;
        while (row < matrix.length && col < matrix.length) {
            if (matrix[row++][col++] == 'q') {
                return false;
            }
        }
        return true;
    }

    private static boolean checkMainDiagonalUpRight(char[][] matrix, int row, int col) {
        row--;
        col++;
        while (row >= 0 && col < matrix.length) {
            if (matrix[row--][col++] == 'q') {
                return false;
            }
        }
        return true;

    }

    private static boolean checkMainDiagonalUpLeft(char[][] matrix, int row, int col) {
        row--;
        col--;
        while (row >= 0 && col >= 0) {
            if (matrix[row--][col--] == 'q') {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfQueenRow(char[][] matrix, int row) {
        int queens = 0;

        for (int i = 0; i < matrix.length; i++) {
            char symbol = matrix[row][i];
            if (symbol == 'q') {
                queens++;
            }
        }
        return queens == 1;

    }

    private static boolean checkIfQueenCol(char[][] matrix, int col) {
        int queens = 0;

        for (int i = 0; i < matrix.length; i++) {
            char symbol = matrix[i][col];
            if (symbol == 'q') {
                queens++;
            }
        }
        return queens == 1;
    }

}

