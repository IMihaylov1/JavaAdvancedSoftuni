import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] element = scanner.nextLine().split(" ");
            elements.addAll(Arrays.asList(element));
        }
        String collect = elements.stream().map(s -> s).collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}
