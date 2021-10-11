import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandCount = scanner.nextInt();//GETTING THE FIRST NUMBER - HOW MANY NUMBERS WILL BE

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> maxStack = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < commandCount; i++) {

            int command = scanner.nextInt();//THE COMMAND NUMBER - WHICH IS IN FRONT OF THE NUMBER

            if (command == 1) {
                int numToPush = scanner.nextInt();//THE NUMBER AFTER THE COMMAND ONE
                stack.push(numToPush);
                if (max <= numToPush) {
                    max = numToPush;
                    maxStack.push(max);
                }
            } else if (command == 2) {
                int poppedItem = stack.pop();//IN THIS CASE WE ARE REMOVING THE ELEMENT PRESENT AT THE TOP OF THE STACK
                if (poppedItem == max) {
                    maxStack.pop();
                    if (maxStack.size() > 0) {
                        max = maxStack.peek();
                    } else {
                        max = Integer.MIN_VALUE;
                    }
                }
            } else {//FOR THE COMMAND WITH NUMBER 3 FOR PRINTING THE MAXIMUM ELEMENT IN THE STACK
                System.out.println(max);
            }
        }
    }
}