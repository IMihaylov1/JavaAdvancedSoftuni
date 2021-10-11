import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class MergeTwoFiles_07 {
    public static void main(String[] args) throws IOException {

        String inputFirst = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String inputSecond = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String output = "C:\\Users\\Mihaylovi\\Desktop\\output.txt";
        List<String> first = Files.readAllLines(Path.of(inputFirst));
        List<String> second = Files.readAllLines(Path.of(inputSecond));
        List<String> list = new ArrayList<>();
        list.addAll(first);
        list.addAll(second);
        Files.write(Path.of(output),list);


    }
}
