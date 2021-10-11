package christmas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }


    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (capacity > data.size()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {

        return this.data.removeIf(present -> present.getName().equals(name));
    }

    public Present getPresent(String name) {
       // Вариант 1:
//        for (Present present : data) {
//            String presentName = present.getName();
//            if (presentName.equals(name)) {
//                return present;
//            }
//        }
//        return null;

        // Вариант 2 :
        return this.data.stream().filter(e-> e.getName().equals(name)).findFirst().orElse(null);
    }

    public Present heaviestPresent() {
        return this.data.stream().max(Comparator.comparing(Present::getWeight)).orElse(null);
    }

    public String report() {


        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%s bag contains:", getColor())).append(System.lineSeparator());
        for (Present present : data) {
            stringBuilder.append(present.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();

    }
//        StringBuilder str = new StringBuilder(String.format("%s bag contains:%n", this.getColor()));
//        for (Present present : this.data) {
//            str.append(present.toString()).append(System.lineSeparator());
//        }
//        return str.toString().trim();
//    }

}
