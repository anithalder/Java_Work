class EmployeeManagement{
    long employeeId;
    String name;
    double salary;
    
    public EmployeeManagement(long employId, String name, double salary){
        this.employeeId = employId;
        this.name = name;
        this.salary = salary;
    }
    
    public void display(){
        System.out.println("Employee Id : " + employeeId);
        System.out.println("Employee Name : " + name);
        System.out.println("Employee Salary : ₹ " + salary + "\n");
    }

    public void bonusCalculator(double bonusPercentage){
        System.out.println("Bonus amount of " + name + " is : " + (salary*bonusPercentage)/100 + "\n");
    }
}
class Employ{
    public static void main(String[] args) {
        EmployeeManagement emp1 = new EmployeeManagement(101, "Raj", 10000);
        EmployeeManagement emp2 = new EmployeeManagement(102, "Ram", 20000);
        EmployeeManagement emp3 = new EmployeeManagement(103, "Sham", 30000);
        
        emp1.display();
        emp2.display();
        emp3.display();
        
        emp1.bonusCalculator(10);
        emp2.bonusCalculator(10.5);
        emp3.bonusCalculator(9.2);
    }
}