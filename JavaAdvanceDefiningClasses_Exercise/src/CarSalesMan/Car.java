package CarSalesMan;

public class Car {
    private String model;

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    private Engine engine;
    private int weight;
    private String color;

    public Car(String model,Engine engine,int weight,String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
    public Car(String model,Engine engine,int weight){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }
    public Car(String model,Engine engine,String color){
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = color;
    }
    public Car(String model,Engine engine){
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

}

