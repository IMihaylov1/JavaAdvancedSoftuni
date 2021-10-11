import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int numbersToPush = input[0];
        int numbersToPop = input[1];
        int numberToContain = input[2];

        for (int i = 0; i < numbersToPush; i++) {
            int num = scanner.nextInt();
            stack.push(num);
        }
        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }

        if (stack.contains(numberToContain)) {
            System.out.println("true");
        } else {
            System.out.println(findSmallElement(stack));
        }
    }

    private static int findSmallElement(ArrayDeque<Integer> stack) {
        int small = Integer.MAX_VALUE;
        if (stack.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < stack.size(); i++) {
            int element = stack.pop();
            if (element < small) {
                small = element;
            }
        }
        return small;
    }
}
