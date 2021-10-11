
import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int row = 0;
        int col = 0;

        for (int i = 0; i < size; i++) {
            System.out.print(matrix[row++][col++] + " ");
        }
        System.out.println();
        row = size - 1;
        col = 0;
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[row--][col++] + " ");

        }
//              1 2 1
//              1 2 3
//              3 2 3
//        Заместител на фор-цикала Принтиране на диагонал "1 2 3"
//        int row = 0;
//        int col = 0;
//        while (row < matrix.length && col < matrix[row].length) {
//            System.out.print(matrix[row++][col++] + " ");
//        }
////        int row = matrix.length - 1;
////        int col = 0;
////        //        Заместител на фор-цикала Принтиране на диагонал "3 2 1"
//        while (row >= 0 && col < matrix[row].length) {
//            System.out.print(matrix[row--][col++] + " ");
//        }
    }
}
