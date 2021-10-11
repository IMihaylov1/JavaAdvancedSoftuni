import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));

        String line = bufferedReader.readLine();
        int sum = 0;
        while (line != null){

            for (char c : line.toCharArray()) {
                sum+=c;
            }

            line = bufferedReader.readLine();
        }
        System.out.println(sum);
    }
}

