package Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Cars.CarOne.carsMove;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<CarOne> allCars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double fuelPerKm = Double.parseDouble(tokens[2]);
            CarOne car = new CarOne(model, fuel, fuelPerKm);
            allCars.add(car);
        }
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String carName = tokens[1];
            double amountToTravelKm = Double.parseDouble(tokens[2]);
            carsMove(allCars, carName, amountToTravelKm);


            input = scanner.nextLine();
        }
        if (!allCars.isEmpty()) {

            for (CarOne car : allCars) {
                System.out.println(String.format("%s %.2f %.0f", car.getModel(), car.getFuel(), car.getDistance()));
            }
        }
    }
}
