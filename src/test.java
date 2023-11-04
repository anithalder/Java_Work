class Animal {
}

class Dog extends Animal {
}

class Parent {
    Animal m1() // overridden method
    {
        System.out.println("parent m1");
        return new Animal();
    }
}

class Child extends Parent {
    Dog m1() // overriding method
    {
        System.out.println("child m1");
        return new Dog();
    }

    public static void main(String[] args) {
        Parent p = new Parent();
        Animal a = p.m1();
        System.out.println(a);
        Child c = new Child();
        Dog d = c.m1();
        System.out.println(d);
    }
};