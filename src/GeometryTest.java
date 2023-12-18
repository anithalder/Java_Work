import geometry.Circle;
import geometry.Rectangle;
import geometry.Triangle;

class GeometryTest {
    public static void main(String[] args) {
        Circle c = new Circle(5.0);
        System.out.println("The area of the circle: " + c.area());
        System.out.println("The perimeter of the circle: " + c.peri());

        Rectangle r = new Rectangle(5.0, 10.0);
        System.out.println("The area of the rectangle: " + r.area());
        System.out.println("The perimeter of the rectangle: " + r.peri());

        Triangle t = new Triangle(5.0, 10.0, 5.0);
        System.out.println("The area of the triangle: " + t.area(2,5));
        System.out.println("The perimeter of the triangle: " + t.peri());
    }
}
