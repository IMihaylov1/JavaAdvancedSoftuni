import java.io.File;
import java.util.ArrayDeque;

public class NestedFolders_08 {
    public static void main(String[] args) {
        String in = "C:\\Users\\Mihaylovi\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(in);

        ArrayDeque<File> queue = new ArrayDeque<>();

        queue.offer(file);

        int count = 1;

        while (!queue.isEmpty()) {
            File current = queue.poll();
            System.out.println(current.getName());
            File[] nestedFiles = current.listFiles();
            for (File f : nestedFiles) {
                if (f.isDirectory()) {
                    queue.offer(f);
                    count++;
                }
            }
        }
        System.out.println(count + " folders");
    }
}
