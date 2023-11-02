class addition_overloading {
    int a,b;
    double x,y;
    int add(int a,int b){
        this.a = a;
        this.b = b;
        return a+b;
    }
    double add(double x,double y){
        this.x = x;
        this.y = y;
        return x+y;
    }
    double add(int a, double x){
        this.a = a;
        this.x = x;
        return a+x;
    }
}

class printing{
    public static void main(String[] args){
        addition_overloading obj = new addition_overloading();
        System.out.println(obj.add(1,2));
        System.out.println(obj.add(1.1,2.2));
        System.out.println(obj.add(1,2.2));
    }
}