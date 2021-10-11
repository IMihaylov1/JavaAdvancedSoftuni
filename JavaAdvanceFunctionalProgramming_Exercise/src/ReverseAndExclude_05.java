import java.util.*;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.reverse(numbers);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(numbers.stream()
                .filter(num -> num % n != 0)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));

    }
}
