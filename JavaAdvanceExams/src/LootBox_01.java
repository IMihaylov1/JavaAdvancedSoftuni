import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LootBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        int[] first = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] second = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i : first) {
            firstBox.offer(i);
        }
        for (int i : second) {
            secondBox.offer(i);
        }
        int sum = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstBoxGet = firstBox.peek();
            int secondBoxGet = secondBox.peekLast();
            int sumFirstAndLast = firstBoxGet + secondBoxGet;

            if (sumFirstAndLast % 2 == 0) {
                sum += sumFirstAndLast;
                firstBox.removeFirst();
                secondBox.removeLast();
            } else {
                int last = secondBox.removeLast();
                firstBox.offerLast(last);
            }

        }
        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sum);
        }
    }
}
