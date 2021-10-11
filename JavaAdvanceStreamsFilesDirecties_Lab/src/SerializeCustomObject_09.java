
import java.io.*;
import java.nio.file.Files;
import java.util.List;

public class SerializeCustomObject_09 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cube cube = new Cube("green", 15.3d, 12.4d, 3d);

        String serializationFile = "C:\\Users\\Mihaylovi\\Desktop\\output.txt";
        String deSerializationFile = "C:\\Users\\Mihaylovi\\Desktop\\deserialization.txt";

        // serialization
        FileOutputStream fos = new FileOutputStream(serializationFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cube);


        // de-serialization
        FileInputStream fis = new FileInputStream(serializationFile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Cube test = (Cube) ois.readObject();
        System.out.println("color = " + test.getColor());

    }
}