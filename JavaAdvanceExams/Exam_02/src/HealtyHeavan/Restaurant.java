package HealtyHeavan;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Salad> data;

    public String getName() {
        return name;
    }

    public Restaurant(String name) {
        this.name = name;
        this.data = new ArrayList<>();
    }

    public void add(Salad salad) {
        this.data.add(salad);
    }

    public boolean buy(String name) {

        return this.data.removeIf(salad -> salad.getName().equals(name));
    }

    public Salad getHealthiestSalad(){
         return this.data.stream().min(Comparator.comparing(Salad::getTotalCalories)).orElse(null);
    }

    public String generateMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s have %d salads:", this.name, this.data.size()));
        stringBuilder.append(System.lineSeparator());
        for (Salad datum : data) {
            stringBuilder.append(datum.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();

    }
}
