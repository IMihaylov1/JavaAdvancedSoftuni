package RawData;

public class Tyre {
    private double tireOnePressure;
    private int tireOneAge;
    private double tireTwoPressure;
    private int tireTwoAge;

    public double getTireOnePressure() {
        return tireOnePressure;
    }

    public int getTireOneAge() {
        return tireOneAge;
    }

    public double getTireTwoPressure() {
        return tireTwoPressure;
    }

    public int getTireTwoAge() {
        return tireTwoAge;
    }

    public double getTireThreePressure() {
        return tireThreePressure;
    }

    public int getTireThreeAge() {
        return tireThreeAge;
    }

    public double getTireFourPressure() {
        return tireFourPressure;
    }

    public int getTireFourAge() {
        return tireFourAge;
    }

    private double tireThreePressure;
    private int tireThreeAge;
    private double tireFourPressure;
    private int tireFourAge;

    public Tyre(double tireOnePressure, int tireOneAge, double tireTwoPressure,
                int tireTwoAge, double tireThreePressure, int tireThreeAge,
                double tireFourPressure, int tireFourAge) {

        this.tireOnePressure = tireOnePressure;
        this.tireOneAge = tireOneAge;
        this.tireTwoPressure = tireTwoPressure;
        this.tireTwoAge = tireTwoAge;
        this.tireThreePressure = tireThreePressure;
        this.tireThreeAge = tireThreeAge;
        this.tireFourPressure = tireFourPressure;
        this.tireFourAge = tireFourAge;
    }


}
