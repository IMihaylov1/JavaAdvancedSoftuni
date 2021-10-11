import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class WordCount_06 {
    public static void main(String[] args) throws IOException {
        String input = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String inputTwo = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";

        String wordsOfFirst = Files.readString(Path.of(input));
        String[] tokens = wordsOfFirst.split(" ");
        String first = tokens[0];
        int firstCount = 0;
        String second = tokens[1];
        int secondCount = 0;
        String third = tokens[2];
        int thirdCount = 0;

        List<String> linesOfSecond = Files.readAllLines(Path.of(inputTwo));
        for (String line : linesOfSecond) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (first.equals(word)) {
                    firstCount++;
                } else if (second.equals(word)) {
                    secondCount++;
                } else if (third.equals(word)) {
                    thirdCount++;
                }
            }
        }
        System.out.println(first + " - " + firstCount);
        System.out.println(second + " - " + secondCount);
        System.out.println(third + " - " + thirdCount);
    }
}
