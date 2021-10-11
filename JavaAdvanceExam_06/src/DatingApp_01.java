import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class DatingApp_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> male = new ArrayDeque<>();
        ArrayDeque<Integer> female = new ArrayDeque<>();
        int matches = 0;

        int[] maleNum = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] femaleNum = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i : maleNum) {
            male.push(i);
        }
        for (int i : femaleNum) {
            female.offer(i);
        }

        while (!male.isEmpty() && !female.isEmpty()) {
            int maleFirst = male.peek();
            int femaleFirst = female.peek();
            if (maleFirst <= 0 && femaleFirst <= 0) {
                male.pop();
                female.poll();
                continue;
            }
            if (maleFirst <= 0) {
                male.pop();
                continue;
            }
            if (femaleFirst <= 0) {
                female.poll();
                continue;
            }
            if (femaleFirst % 25 == 0) {
                female.poll();
                female.poll();
                continue;
            }
            if (maleFirst % 25 == 0) {
                male.pop();
                male.pop();
                continue;
            }
            if (maleFirst == femaleFirst) {
                matches++;
                male.pop();
                female.poll();
            } else {
                female.poll();
                Integer pop = male.pop() - 2;
                male.push(pop);
            }
        }

        System.out.println("Matches: " + matches);
        if (male.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");

            printArrayDeque(male);
        }
        if (female.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            printArrayDeque(female);

        }
    }

    private static void printArrayDeque(ArrayDeque<Integer> queueBombCasing) {
        for (int i = 0; i < queueBombCasing.size(); i++) {
            if (i == queueBombCasing.size() - 1) {
                System.out.println(queueBombCasing.pop());
            } else {
                System.out.print(queueBombCasing.pop() + ", ");
                i--;
            }
        }
    }
}
