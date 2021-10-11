package Car;

public class Car {

    private String make;
    private String model;
    private int horsePower;

    public Car(String make) {
        this.make = make;
        this.model = "unknown";
        this.horsePower = -1;
    }
    public Car(String make,String model,int horsePower){
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public String getMake() {
        return this.make;
    }


    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

}

