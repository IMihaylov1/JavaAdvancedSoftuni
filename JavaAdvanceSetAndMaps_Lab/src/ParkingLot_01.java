import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> carPark = new LinkedHashSet<>();

        String command = scanner.nextLine();
        while (!command.equals("END")){
        String[] tokens = command.split(", ");
        String inOrOut = tokens[0];
        String carPlate = tokens[1];
        if(inOrOut.equals("IN")){
            carPark.add(carPlate);
        }else if(inOrOut.equals("OUT")){
            carPark.remove(carPlate);
        }
            command = scanner.nextLine();
        }
        if(carPark.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            carPark.forEach(System.out::println);
        }

    }
}
