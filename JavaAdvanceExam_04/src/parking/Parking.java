package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(pet -> pet.getManufacturer().equals(manufacturer) && pet.getModel().equals(model));
    }

    public String getType() {
        return type;
    }

    public Car getLatestCar() {
        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data) {
            String carManufacturer = car.getManufacturer();
            String carModel = car.getModel();
            if (carManufacturer.equals(manufacturer) && carModel.equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("The cars are parked in %s:", getType())).append(System.lineSeparator());
        for (Car car : data) {
            stringBuilder.append(car.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
