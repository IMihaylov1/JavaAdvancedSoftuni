import java.io.Serializable;

public class Cube implements Serializable {
    //    color, width, height and depth
    private String color;
    private double width;
    private double height;
    private double depth;


    public Cube(String color, double width, double height, double depth) {

        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;

    }

    public String getColor() {
        return this.color;
    }
}
