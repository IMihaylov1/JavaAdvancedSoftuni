package Cars;

import java.util.List;

public class CarOne {
//     Model, fuel amount, fuel cost for 1 kilometer and distance traveled.

    private String model;
    private double fuel;
    private double fuelPerKm;
    private double distance;


    public CarOne(String model, double fuel, double fuelPerKm) {
        this.model = model;
        this.fuel = fuel;
        this.fuelPerKm = fuelPerKm;
        this.distance = 0;
    }

    public String getModel() {
        return this.model;
    }

    public double getFuel() {
        return this.fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuelPerKm() {
        return this.fuelPerKm;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance += distance;
    }
    public static void carsMove(List<CarOne> allCars, String carName, double amountToTravelKm) {
        for (CarOne car : allCars) {
            if (car.getModel().equals(carName)) {
                double fuelToTravel = amountToTravelKm * car.getFuelPerKm();
                if (car.getFuel() >= fuelToTravel) {
                    double fuelOfCar = car.getFuel();
                    double fuelToReduce = fuelOfCar - fuelToTravel;
                    car.setFuel(fuelToReduce);
                    car.setDistance(amountToTravelKm);
                } else {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
        }
    }
}
