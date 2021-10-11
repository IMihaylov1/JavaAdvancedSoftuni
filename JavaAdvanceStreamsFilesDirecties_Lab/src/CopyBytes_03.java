import java.io.*;
import java.util.Arrays;

public class CopyBytes_03 {
    public static void main(String[] args) throws IOException {

        String in = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String out = "C:\\Users\\Mihaylovi\\Desktop\\output.txt";
        InputStream inputStream = new FileInputStream(in);
        OutputStream outputStream = new FileOutputStream(out);

        int bytes = 0;
        while ((bytes = inputStream.read()) >= 0) {
            if (bytes == 10 || bytes == 32) {
                outputStream.write(bytes);
            } else {
                String digit = String.valueOf(bytes);
                for (int i = 0; i < digit.length(); i++) {
                    outputStream.write(digit.charAt(i));
                }
            }
        }

    }
}
