package HealtyHeavan;

import java.util.ArrayList;
import java.util.List;

public class Salad {
    private String name;
    private List<Vegetable> products ;

    public Salad(String name) {
        this.name = name;
        this.products  = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getTotalCalories() {
        return this.products .stream().mapToInt(Vegetable::getCalories).sum();
    }

    public int getProductCount() {

        return products .size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append( String.format("* Salad %s is %d calories and have %d products:"
                , this.getName(),this.getTotalCalories() ,this.getProductCount()));
        stringBuilder.append(System.lineSeparator());

        for (Vegetable vegetable : products ) {
            stringBuilder.append(vegetable.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
