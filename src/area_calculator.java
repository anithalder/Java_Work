class Shape{
    double calculateArea(){
        return 0;
    }
}

class Rectangle extends Shape{
    double height,width;

    Rectangle(double height,double width){
        this.height = height;
        this.width = width;
    }

    double calculateArea(){
        return (height*width);
    }
}

class Circle extends Shape{
    double radios,pi=3.14;

    Circle(double radios){
        this.radios = radios;
    }

    double calculateArea(){
        return (pi*radios*radios);
    }
}

class area_calculator{
    public static void main(String[] args) {
        Rectangle r = new Rectangle(10,20);
        Circle c = new Circle(10);

        System.out.println("Area of Rectangle is: "+r.calculateArea());
        System.out.println("Area of Circle is: "+c.calculateArea());
    }
}