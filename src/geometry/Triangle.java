package geometry;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;

    // Constructor
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Methods
    public double area(double breadth,double height) {
        // Implement the area calculation for a triangle (e.g., using Heron's formula)
        // For simplicity, I'll leave it unimplemented in this example.
        return (breadth * height / 2);
    }

    public double peri() {
        return side1 + side2 + side3;
    }
}
