import java.io.File;

public class GetFoldersSize_08 {
    public static void main(String[] args) {

        String inputFirst = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File file = new File(inputFirst);
        long size = getSize(file);
        System.out.println(size);
    }

    public static long getSize(File file) {
        long size;
        if (file.isDirectory()) {
            size = 0;
            for (File child : file.listFiles()) {
                size += getSize(child);
            }
        } else {
            size = file.length();
        }
        return size;
    }
}
