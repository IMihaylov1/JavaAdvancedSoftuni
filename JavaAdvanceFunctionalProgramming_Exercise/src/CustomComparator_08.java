import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CustomComparator_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(Comparator.comparingInt((Integer f) -> Math.abs(f % 2)).thenComparingInt(f -> f))
                .map(e -> e + " ")
                .forEach(System.out::print);
    }
}
