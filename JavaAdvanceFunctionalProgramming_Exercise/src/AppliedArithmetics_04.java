import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s++"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        Map<String, Function<List<Integer>, List<Integer>>> functions = new HashMap<>();
        functions.put("add", e -> e.stream()
                .map(val -> val + 1)
                .collect(Collectors.toList()));
        functions.put("multiply", e -> e.stream()
                .map(val -> val * 2)
                .collect(Collectors.toList()));

        functions.put("subtract", e -> e.stream()
                .map(val -> val - 1)
                .collect(Collectors.toList()));
        functions.put("print", e -> e.stream()
                .peek(elem -> System.out.print(elem + " "))
                .collect(Collectors.toList()));

        while (!input.equals("end")) {

            numbers = functions.get(input).apply(numbers);
            if (input.equals("print")) {
                System.out.println();
            }
            input = scanner.nextLine();
        }
    }
}
