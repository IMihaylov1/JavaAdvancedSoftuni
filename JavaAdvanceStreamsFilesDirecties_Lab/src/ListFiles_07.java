import java.io.File;
import java.io.FileNotFoundException;


public class ListFiles_07 {
    public static void main(String[] args) throws FileNotFoundException {

        String in = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(in);
        File[] files = file.listFiles();

        for (File f : files) {
            if(!f.isDirectory()){
                System.out.printf("%s: [%d]%n",f.getName(),f.length());
            }
        }
    }
}
