import java.util.Scanner;

class First
{
    public static void main(String args[])
    {

        int javaDateOfAppearance = 1995;

        System.out.println("Hello what's your name?");

        //Store a users input in a string variable called name
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        //Greeting message to the user
        System.out.println("Well I hope you are doing great " + name );
        System.out.println("What is your birth year?");

        //Store a users input in an integer variable called age
        int age = scanner.nextInt();

        //Calculating difference between user age and the year Java was published
        int differenceInAge = age - javaDateOfAppearance;

        //If user is younger than Java
        if(age > javaDateOfAppearance ){
            System.out.println("Wow you are " + differenceInAge + " younger than Java!" );
            System.out.println("Keep on finding those bugs!");
        }
        //If user was birth the same year as Java's first publication
        else if ( age == javaDateOfAppearance) {
            System.out.println("You were born the exact same year Java was first published!" );
            System.out.println("What a great co-incidence, stay coding!");
        }
        //If user is older than Java
        else{
            System.out.println("Wow you are " + differenceInAge + " years older than Java!" );
            System.out.println("Stay awesome you code geek!");
        }
    }
}