import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> resources = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!resources.containsKey(input)) {
                resources.put(input, 0);
                resources.put(input, quantity);
            } else {
                Integer currentQuantity = resources.get(input);
                resources.put(input, currentQuantity + quantity);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }
}
