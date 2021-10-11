package RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tyre getTyre() {
        return tyre;
    }

    private Tyre tyre;

public Car(String model,Engine engine,Cargo cargo,Tyre tyre){
    this.model = model;
    this.engine = engine;
    this.cargo = cargo;
    this.tyre = tyre;
}
public String getModel(){
    return this.model;
}

}
