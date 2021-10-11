
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterType_04 {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";


        int countVowels = 0;
        int countPunctuation = 0;
        int countAllOthers = 0;
        List<String> lines = Files.readAllLines(Path.of(input));
        for (String line : lines) {
            char[] chars = line.toCharArray();
            for (char c : chars) {
                switch (c) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        countVowels++;
                        break;
                    case '!':
                    case ',':
                    case '.':
                    case '?':
                        countPunctuation++;
                        break;
                    case ' ':
                        break;
                    default:
                        countAllOthers++;

                }
            }
        }
        System.out.println("Vowels: " + countVowels);
        System.out.println("Consonants: " + countAllOthers);
        System.out.println("Punctuation: " + countPunctuation);

    }
}
