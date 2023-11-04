class Vehicle {
    String brand;
    int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }
}

class Car extends Vehicle {
    int numDoors;

    public Car(String brand, int year, int numDoors) {
        super(brand, year);
        this.numDoors = numDoors;
    }


    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numDoors);
    }
}

class car_detail{
    public static void main(String[] args) {
        Vehicle myVehicle = new Vehicle("Toyota", 2022);
        myVehicle.displayInfo();

        Car myCar = new Car("Honda", 2023, 4);
        myCar.displayInfo();
    }
}
