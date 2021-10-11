import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] split = input.split("\\s+");
        int count = 0;
        List<String> wordsToSave = new ArrayList<>();
        for (String word : split) {
            char first = word.charAt(0);
            if(Character.isUpperCase(first)){
                count++;
                wordsToSave.add(word);
            }
        }
        System.out.println(count);
        for (String word : wordsToSave) {
            System.out.println(word);
        }
    }
}
