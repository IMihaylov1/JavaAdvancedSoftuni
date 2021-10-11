import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> start = new ArrayDeque<>();

        boolean areBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '{' || symbol == '[' || symbol == '(') {
                start.push(symbol);
            } else {
                if (start.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char top = start.pop();
                if (!(top == '{' && symbol == '}' || top == '[' && symbol == ']' || top == '(' && symbol == ')')){
                    areBalanced = false;
                    break;
                }
            }
        }
        String output = areBalanced ? "YES" : "NO";

        System.out.println(output);
    }
}