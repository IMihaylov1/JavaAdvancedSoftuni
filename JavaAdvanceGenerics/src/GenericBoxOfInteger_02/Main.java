package GenericBoxOfInteger_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Integer>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(number);
            boxList.add(box);
        }
        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");
        int firstIndex = Integer.parseInt(tokens[0]);
        int secondIndex = Integer.parseInt(tokens[1]);

        swapElements(boxList, firstIndex, secondIndex);

        for (Box<Integer> box : boxList) {
            System.out.println(box.toString());
        }
    }

    private static <T> void swapElements(List<Box<T>> boxList, int firstIndex, int secondIndex) {
        Box<T> temp = boxList.get(firstIndex);
        boxList.set(firstIndex, boxList.get(secondIndex));
        boxList.set(secondIndex,temp);

    }

}
