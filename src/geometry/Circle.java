package geometry;

public class Circle {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Methods
    public double area() {
        return Math.PI * radius * radius;
    }

    public double peri() {
        return 2 * Math.PI * radius;
    }
}
