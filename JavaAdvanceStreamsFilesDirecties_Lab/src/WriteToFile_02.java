import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WriteToFile_02 {
    public static void main(String[] args) throws IOException {
        String pathIn = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "C:\\Users\\Mihaylovi\\Desktop\\output.txt";


        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols,'.',',','!','?');

        InputStream inputStream = new FileInputStream(pathIn);
        OutputStream outputStream = new FileOutputStream(pathOut);

        int oneByte;
        while ((oneByte=inputStream.read())>=0){
            if(!symbols.contains((char)oneByte)){
                outputStream.write(oneByte);
            }
        }
        inputStream.close();
        outputStream.close();

    }

}
