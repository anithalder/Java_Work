class Employee{
    private String name,designation;
    int empId,salary;

    Employee(String name, int empId, int salary, String designation){
        this.name = name;
        this.empId = empId;
        this.salary = salary;
        this.designation = designation;
    }

    public void getDetails(){
        System.out.println("| Name: " + name + " | EmpId: " + empId + " | Salary: " + salary + "| Designation: " + designation + " |\n");
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("John", 101, 20000, "Manager");
        Employee e2 = new Employee("Jennie", 102, 30000, "Developer");
        Employee e3 = new Employee("Jim", 103, 40000, "Tester");
        e1.getDetails();
        e2.getDetails();
        e3.getDetails();
    }
}