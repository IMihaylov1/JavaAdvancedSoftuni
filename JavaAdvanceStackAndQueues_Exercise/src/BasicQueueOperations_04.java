import java.util.ArrayDeque;

import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] token = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(token[0]);
        int sToRemove = Integer.parseInt(token[1]);
        int xToCheck = Integer.parseInt(token[2]);

        String[] tokens = scanner.nextLine().split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            stack.offer(Integer.parseInt(tokens[i]));
        }

        for (int i = 0; i < sToRemove; i++) {
            stack.pop();
        }

        if (stack.contains(xToCheck)) {
            System.out.println("true");
        } else if (stack.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(Collections.min(stack));
        }

    }
//    private static int findSmallElement(ArrayDeque<Integer> queue) {
//        int small = Integer.MAX_VALUE;
//        if (queue.isEmpty()) {
//            return 0;
//        }
//        for (int i = 0; i < queue.size(); i++) {
//            int element = queue.poll();
//            if (element <= small) {
//                small = element;
//            }
//        }
//        return small;
//    }
}
