package RawData;

public class Engine {
    public int getEngineSpeed() {
        return engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    private int engineSpeed;
    private int enginePower;

    public Engine(int engineSpeed,int enginePower){
        this.engineSpeed=engineSpeed;
        this.enginePower=enginePower;

    }
}
