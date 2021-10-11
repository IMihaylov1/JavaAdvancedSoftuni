import java.io.*;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws FileNotFoundException {

        String in = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String out = "C:\\Users\\Mihaylovi\\Desktop\\output.txt";
        Scanner scanner = new Scanner(new FileInputStream(in));
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(out));
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printWriter.println(scanner.nextInt());
            }

            scanner.next();
        }
        printWriter.close();

    }
}
