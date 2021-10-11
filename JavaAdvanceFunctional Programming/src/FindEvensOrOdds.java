import java.util.Arrays;
import java.util.Scanner;


public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] lineIntegers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int begin = lineIntegers[0];
        int finish = lineIntegers[1];
        String condition = scanner.nextLine();

        findEvensOrOdd(begin, finish, condition);
    }




    private static void findEvensOrOdd(int begin, int finish, String condition) {
        if (condition.equals("odd")) {
            for (int i = begin; i <= finish; i++) {
                if (i % 2 != 0) {
                    System.out.print(i + " ");
                }
            }
        } else if(condition.equals("even")){
            for (int i = begin; i <= finish; i++) {
                if (i % 2 == 0) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
