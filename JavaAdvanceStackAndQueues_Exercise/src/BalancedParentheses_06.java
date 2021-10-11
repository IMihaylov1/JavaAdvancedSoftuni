
import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. ако скобата е отворена -> запазваме
        //2. ако е затворена -> търсим в отворените дали последната отворена ми отговаря на затворената
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();
        String input = scanner.nextLine();
        boolean areBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            //отворена
            if (currentBracket == '{' || currentBracket == '[' || currentBracket == '(') {
                openBrackets.push(currentBracket);
            } else if (currentBracket == '}' || currentBracket == ']' || currentBracket == ')') {
                //затворена
                //!!!! empty
                if(openBrackets.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char open = openBrackets.pop();
                if (currentBracket == '}' && open != '{') {
                    //не
                    areBalanced = false;
                } else if (currentBracket == ']' && open != '[') {
                    //не
                    areBalanced = false;
                } else if (currentBracket == ')' && open != '(') {
                    //не
                    areBalanced = false;
                }
            }
        }

        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}