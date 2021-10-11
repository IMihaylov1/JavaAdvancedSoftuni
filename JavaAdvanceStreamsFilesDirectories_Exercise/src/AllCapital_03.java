import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AllCapital_03 {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        String output = "C:\\Users\\Mihaylovi\\Desktop\\output.txt";

        List<String> lines = Files.readAllLines(Path.of(input));

        List<String> upperCase = new ArrayList<>();
        for (String line : lines) {
            upperCase.add(line.toUpperCase());
        }
        Files.write(Path.of(output),upperCase);
    }
}
