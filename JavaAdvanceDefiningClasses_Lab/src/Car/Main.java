package Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            if(tokens.length == 3) {

                String carMake = tokens[0];
                String carType = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                Car car = new Car(carMake, carType, horsePower);
                cars.add(car);
            }else {
                String carMake = tokens[0];
                Car car = new Car(carMake);
                cars.add(car);
            }
        }
        for (Car car : cars) {
            getInfo(car);
        }


    }


    public static void getInfo(Car car) {
        System.out.println(String.format("The car is: %s %s - %d HP.", car.getMake(), car.getModel(), car.getHorsePower()));
    }
}