import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));

        String line = bufferedReader.readLine();

        while (line != null){
            int sum = 0;
            for (char c : line.toCharArray()) {
                sum+=c;
            }
            System.out.println(sum);
            line = bufferedReader.readLine();
        }
    }
}
