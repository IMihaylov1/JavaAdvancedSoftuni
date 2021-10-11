import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String command = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (!command.equals("print")) {
            if (command.equals("cancel")) {
                if (!queue.isEmpty()) {
                    System.out.printf("Canceled %s%n", queue.pop());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                queue.offer(command);
            }
            command = scanner.nextLine();
        }
        for (String print : queue) {
            System.out.println(print);
        }

    }
}
