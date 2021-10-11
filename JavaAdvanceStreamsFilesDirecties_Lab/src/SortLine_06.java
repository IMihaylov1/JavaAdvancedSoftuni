import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class SortLine_06 {
    public static void main(String[] args) throws IOException {
        String in = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String out = "C:\\Users\\Mihaylovi\\Desktop\\output.txt";
        List<String> strings = Files.readAllLines(Path.of(in))
                .stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());

        Files.write(Path.of(out),strings);
    }
}
