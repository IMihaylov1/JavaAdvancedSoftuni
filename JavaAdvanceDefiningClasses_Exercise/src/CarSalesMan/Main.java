package CarSalesMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> carsEngine = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokensEngine = input.split("\\s+");

            String modelEngine = tokensEngine[0];
            int powerEngine = Integer.parseInt(tokensEngine[1]);

            if (tokensEngine.length == 4) {
                int displacement = Integer.parseInt(tokensEngine[2]);
                String efficiency = tokensEngine[3];
                Engine engine = new Engine(modelEngine, powerEngine, displacement, efficiency);
                carsEngine.add(engine);
            } else if (tokensEngine.length == 3) {
                try {
                    int displasment = Integer.parseInt(tokensEngine[2]);
                    Engine engine = new Engine(modelEngine, powerEngine, displasment);
                    carsEngine.add(engine);
                } catch (NumberFormatException exception) {
                    String efficiency = tokensEngine[2];
                    Engine engine = new Engine(modelEngine, powerEngine, efficiency);
                    carsEngine.add(engine);
                }
            } else if (tokensEngine.length == 2) {
                Engine engine = new Engine(modelEngine, powerEngine);
                carsEngine.add(engine);
            }
        }

        int m = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String input = scanner.nextLine();
            String[] carsTokens = input.split("\\s+");
            String modelCar = carsTokens[0];
            String engineCar = carsTokens[1];
            if (carsTokens.length == 4) {
                int weightCar = Integer.parseInt(carsTokens[2]);
                String colorCar = carsTokens[3];
                for (Engine carEngine : carsEngine) {
                    if (carEngine.getModel().equals(engineCar)) {
                        Car car = new Car(modelCar, carEngine, weightCar, colorCar);
                        carsList.add(car);
                    }
                }
            } else if (carsTokens.length == 3) {
                try {
                    int weightCar = Integer.parseInt(carsTokens[2]);
                    for (Engine engine : carsEngine) {
                        if (engine.getModel().equals(engineCar)) {
                            Car car = new Car(modelCar, engine, weightCar);
                            carsList.add(car);
                        }
                    }
                } catch (NumberFormatException exception) {
                    String color = carsTokens[2];
                    for (Engine engine : carsEngine) {
                        if (engine.getModel().equals(engineCar)) {
                            Car car = new Car(modelCar, engine, color);
                            carsList.add(car);
                        }
                    }

                }
            } else if (carsTokens.length == 2) {
                for (Engine engine : carsEngine) {
                    if (engine.getModel().equals(engineCar)) {
                        Car car = new Car(modelCar, engine);
                        carsList.add(car);
                    }
                }
            }
        }

        for (Car car : carsList) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine().getModel() + ":");
            System.out.printf("Power: %d%n", car.getEngine().getPower());
            if (car.getEngine().getDisplacement() != 0) {
                System.out.printf("Displacement: %d%n", car.getEngine().getDisplacement());
            } else {
                System.out.println("Displacement: " + "n/a");
            }
            System.out.println("Efficiency: " + car.getEngine().getEfficiency());
            if (car.getWeight() != 0) {
                System.out.println("Weight: " + car.getWeight());
            } else {
                System.out.println("Weight: " + "n/a");
            }
            System.out.println("Color: "+car.getColor());
        }

    }
}
