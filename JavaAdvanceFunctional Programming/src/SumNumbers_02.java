import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumNumbers_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lineIntegers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> integerList = new ArrayList<>();
        for (int integer : lineIntegers) {
            integerList.add(integer);
        }
        long count = integerList.stream().mapToInt(Integer::intValue).count();
        int sum = integerList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);
    }
}
