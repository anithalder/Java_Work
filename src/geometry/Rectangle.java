package geometry;

public class Rectangle {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Methods
    public double area() {
        return length * width;
    }

    public double peri() {
        return 2 * (length + width);
    }
}
