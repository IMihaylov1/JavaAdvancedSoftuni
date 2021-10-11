package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carsLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tireOnePressure = Double.parseDouble(tokens[5]);
            int tireOneAge = Integer.parseInt(tokens[6]);
            double tireTwoPressure = Double.parseDouble(tokens[7]);
            int tireTwoAge = Integer.parseInt(tokens[8]);
            double tireThreePressure = Double.parseDouble(tokens[9]);
            int tireThreeAge = Integer.parseInt(tokens[10]);
            double tireFourPressure = Double.parseDouble(tokens[11]);
            int tireFourAge = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tyre tyre = new Tyre(tireOnePressure, tireOneAge, tireTwoPressure, tireTwoAge, tireThreePressure, tireThreeAge, tireFourPressure, tireFourAge);
            Car car = new Car(model, engine, cargo, tyre);
            carsLists.add(car);

        }
        String input = scanner.nextLine();
        List<Car> fragile = new ArrayList<>();
        List<Car> flamable = new ArrayList<>();
        if (input.equals("fragile")) {
            for (Car car : carsLists) {
                if (car.getCargo().getCargoType().equals("fragile")) {
                    fragile.add(car);
                }
            }
            List<Car> outputFragile = new ArrayList<>();
            for (Car car : fragile) {
                if (car.getTyre().getTireOnePressure() < 1 || car.getTyre().getTireTwoPressure() < 1
                        || car.getTyre().getTireThreePressure() < 1 || car.getTyre().getTireFourPressure()<1){
                    outputFragile.add(car);
                }
            }
            for (Car car : outputFragile) {
                System.out.println(car.getModel());
            }

        } else if (input.equals("flamable")) {
            for (Car car : carsLists) {
                if(car.getCargo().getCargoType().equals("flamable")){
                    flamable.add(car);
                }
            }
            List<Car> outputFlamable = new ArrayList<>();
            for (Car car : flamable) {
                if(car.getEngine().getEnginePower()>250){
                    outputFlamable.add(car);
                }
            }

            for (Car car : outputFlamable) {
                System.out.println(car.getModel());
            }
        }

    }
}
