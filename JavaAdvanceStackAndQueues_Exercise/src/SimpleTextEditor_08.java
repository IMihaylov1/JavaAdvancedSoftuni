import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Stack<String> lastStrings = new Stack<>();
        
        String currentString = "";

        lastStrings.push(currentString);
        for (int i = 0; i < n; i++) {
            String[] currentCommand = scanner.nextLine().split("\\s+");

            switch (currentCommand[0]) {
                case "1": {
                    currentString += currentCommand[1];
                    lastStrings.push(currentString);
                }
                break;
                case "2": {
                    int countOfLastEl = Integer.parseInt(currentCommand[1]);
                    StringBuilder str = new StringBuilder();
                    currentString = currentString.substring(0, currentString.length() - countOfLastEl);

                    lastStrings.push(currentString);

                }
                break;
                case "3": {

                    int indexForPrint = Integer.parseInt(currentCommand[1]);
                    char letter = currentString.charAt(indexForPrint-1);
                    System.out.println(letter);

                }
                break;
                case "4": {
                    lastStrings.pop();
                    currentString = lastStrings.peek();

                }
                break;

            }
        }
    }
}


