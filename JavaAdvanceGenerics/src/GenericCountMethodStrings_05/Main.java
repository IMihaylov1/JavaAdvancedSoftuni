package GenericCountMethodStrings_05;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Double>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Double element = Double.parseDouble(scanner.nextLine());
            Box<Double> box = new Box<>(element);
            boxList.add(box);
        }
        Box<Double> input = new Box<>(Double.parseDouble(scanner.nextLine()));
        int count = countGreaterElements(boxList, input);
        System.out.println(count);
    }

    private static <T extends Comparable<T>> int countGreaterElements(List<Box<T>> boxList, Box<T> input) {
        int count = 0;
        for (Box<T> box : boxList) {
            if (box.compareTo(input) > 0) {
                count++;
            }
        }
        return count;
    }
}
