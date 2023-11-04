class Animal{
    void makeSound(){
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal{
    void makeSound(){
        System.out.println("Miaow Miaow");
    }
}

class Cat extends Animal{
    void makeSound(){
        System.out.println("Bhow Bhow");
    }
}

class animal_voice {
    public static void main(String[] args) {
        Animal a = new Animal();
        Dog d = new Dog();
        Cat c = new Cat();

        a.makeSound();
        d.makeSound();
        c.makeSound();
    }
}
