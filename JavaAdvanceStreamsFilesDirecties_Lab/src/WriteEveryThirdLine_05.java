import java.io.*;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) throws IOException {

        String in = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String out = "C:\\Users\\Mihaylovi\\Desktop\\output.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(in));
        PrintWriter printWriter = new PrintWriter(new FileWriter(out));
        int counter = 1;
        String line = bufferedReader.readLine();
        while (line != null) {
            if (counter % 3 == 0) {
                printWriter.println(line);
            }
            counter++;
            line = bufferedReader.readLine();
        }
        printWriter.close();
    }
}
