package vetClinic;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.data.size()) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
//        for (Pet pet : data) {
//            String petName = pet.getName();
//            if (petName.equals(name)) {
//                data.remove(pet);
//                return true;
//            }
//        }
//        return false;
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            String petName = pet.getName();
            String petOwner = pet.getOwner();
            if (petName.equals(name) && petOwner.equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
//        Pet pets = null;
//        int minAge = Integer.MAX_VALUE;
//        for (Pet pet : data) {
//            if (pet.getAge() < minAge) {
//                pets = pet;
//            }
//        }
//        return pets;
        return this.data.stream().min(Comparator.comparing(Pet::getAge)).orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The clinic has the following patients:");
        stringBuilder.append(System.lineSeparator());
        for (Pet pet : data) {
            stringBuilder.append(pet.getName()).append(" ").append(pet.getOwner());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
