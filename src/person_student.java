class Person{
    int age;
    String name;
    
    Person(int age,String name){
        this.age = age;
        this.name = name;
    }

    void displayInfo(){
        System.out.println("Age : "+age);
        System.out.println("Name : "+name);
    }
}

class Student extends Person{
    int studentID;
    Student(int age,String name,int studentID){
        super(age,name);
        this.studentID = studentID;
    }

    void displayInfo() {
        System.out.println("Age : " + age);
        System.out.println("Name : " + name);
        System.out.println("Student ID : " + studentID);
    }
}

class person_student {
    public static void main(String[] args) {
        Student s1 = new Student(20,"Ram",101);
        s1.displayInfo();
    }
}
