package GenericBox_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String box = scanner.nextLine();
            Box<String> box1 = new Box<>(box);
            boxList.add(box1);
        }
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();
        swapElements(boxList, firstIndex, secondIndex);

        boxList.forEach(e->System.out.println(e.toString()));
    }

    private static <T> void swapElements(List<Box<T>> boxList, int firstIndex, int secondIndex) {
        Box<T> temp = boxList.get(firstIndex);
        boxList.set(firstIndex, boxList.get(secondIndex));
        boxList.set(secondIndex, temp);

    }
}
