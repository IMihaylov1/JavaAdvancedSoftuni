package rabbits;

import java.util.ArrayList;
import java.util.List;

public class Cage {

    private String name;
    private int capacity;
    private List<Rabbit> data;


    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return
                this.capacity;
    }



    public boolean removeRabbit(String name) {
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name));
    }

    public void removeSpecies(String species) {
        data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        for (Rabbit rabbit : data) {
            String rabbitName = rabbit.getName();
            if (rabbitName.equals(name)) {
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbitList = new ArrayList<>();
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) {
                rabbit.setAvailable(false);
                rabbitList.add(rabbit);
            }
        }
        if (rabbitList.isEmpty()) {
            return null;
        } else {
            return rabbitList;
        }
    }

    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Rabbits available at %s:%n", this.getName()));
        for (Rabbit rabbit : data) {
            if (rabbit.isAvailable()) {
                stringBuilder.append(rabbit.toString()).append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }


    public void add(Rabbit rabbit) {
            if (this.data.size() < capacity) {
                this.data.add(rabbit);
            }
        }
}
