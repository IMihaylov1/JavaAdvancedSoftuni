import java.util.*;
import java.util.stream.Collectors;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        int m = scanner.nextInt();

        LinkedHashSet<Integer> first = readSetOfNumbers(n, scanner);
        LinkedHashSet<Integer> second = readSetOfNumbers(m, scanner);
        first.retainAll(second);

        String collect = first.stream()
                .map(integer -> integer + "")
                .collect(Collectors.joining(" "));
        System.out.println(collect);

    }

    private static LinkedHashSet<Integer> readSetOfNumbers(int count, Scanner scanner) {

        LinkedHashSet<Integer> numbers = new LinkedHashSet<>();
        while (count-- > 0) {
            numbers.add(scanner.nextInt());
        }
        return numbers;
    }
}
