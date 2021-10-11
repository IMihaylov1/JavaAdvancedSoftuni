import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] name = scanner.nextLine().split("\\s+");
        for (String s : name) {
            Consumer<String> names = message -> System.out.println("Sir " + message);
            names.accept(s);
        }
    }
}