import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {
        String input = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String output = "C:\\Users\\Mihaylovi\\Desktop\\output.txt";

        List<String> lines = Files.readAllLines(Path.of(input));
        List<String> stringList = new ArrayList<>();
        int counter = 1;
        for (String line : lines) {
            String lineWithNum = counter +". "+line;
            stringList.add(lineWithNum);
            counter++;
        }
      Files.write(Path.of(output),stringList);


    }
}
