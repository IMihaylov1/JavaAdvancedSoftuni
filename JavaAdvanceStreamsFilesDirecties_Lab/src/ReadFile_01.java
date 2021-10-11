
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;



public class ReadFile_01 {
    public static void main(String[] args) throws IOException {
        String pathIn = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        byte[] bytes = Files.readAllBytes(Path.of(pathIn));

        for (byte b : bytes) {
            System.out.print(Integer.toBinaryString(b) + " ");
        }

    }

}
