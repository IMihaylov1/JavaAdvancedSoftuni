import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Problem_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        int[] task = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] tread = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i : task) {
            tasks.push(i);
        }
        for (int i : tread) {
            threads.offer(i);
        }
        int target = Integer.parseInt(scanner.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()) {

            int firstTask = tasks.peek();
            int firstThread = threads.peek();

            if (firstTask == target) {
                Integer threadDefeat = threads.poll();
                System.out.printf("Thread with value %d killed task %d%n", threadDefeat, target);
                System.out.print(threadDefeat + " ");
                printArrayDeque(threads);
                return;

            }
            if (firstThread >= firstTask) {
                threads.poll();
                tasks.pop();
            }
            if (firstThread < firstTask) {
                threads.poll();
                continue;
            }


        }
    }

    private static void printArrayDeque(ArrayDeque<Integer> queueBombCasing) {
        for (int i = 0; i < queueBombCasing.size(); i++) {
            if (i == queueBombCasing.size() - 1) {
                System.out.println(queueBombCasing.pop());
            } else {
                System.out.print(queueBombCasing.pop() + " ");
                i--;
            }
        }
    }

}
