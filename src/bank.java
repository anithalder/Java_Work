import java.util.Scanner;
import java.io.Console;
import java.util.concurrent.TimeUnit;

class BankAccount {
    long accNo;
    String accHolder;
    double balance;
    String password;

    public BankAccount(long accNo, String accHolder, String password, double balance) {
        this.accHolder = accHolder;
        this.accNo = accNo;
        this.balance = balance;
        this.password = password;
    }

    public void displayAccountInfo() {
        System.out.println("\t\t\tAccount Number: " + accNo);
        System.out.println("\t\t\tAccount Holder: " + accHolder);
        System.out.println("\t\t\tBalance: ₹ " + balance + "\n");
    }
}

class withdrawDeposit extends BankAccount{
    String RESET = "\u001B[0m";
    String RED = "\u001B[31m";
    String GREEN = "\u001B[32m";
    String BLUE = "\u001B[34m";
    String YELLOW = "\u001B[33m";

    public withdrawDeposit(long accNo, String accHolder, String password, double balance) {
        super(accNo, accHolder, password, balance);
        //TODO Auto-generated constructor stub
    }

    public void deposit(double amount) throws InterruptedException {
        if (amount > 0) {
            System.out.println("\n\n\t\t Please wait while your transaction is being processing....\n");
            TimeUnit.SECONDS.sleep(10);
            balance += amount;
            System.out.println(BLUE + "\n\n\t\t*" + GREEN + " + ₹ " + amount + BLUE + " Deposited Successfully in " + YELLOW + accHolder + BLUE +"'s account 🤑👍 *" + RESET);
            System.out.println(BLUE + "\n\n\t\t\t* Thank you for trusting us. See you soon 🤗🤗 *" + RESET);
        } 
        else {
            System.out.println(RED + "\t\t! Invalid deposit amount !" + RESET);
        }
    }

    public void withdraw(double amount) throws InterruptedException {
        if (amount > 0 && amount <= balance) {
            System.out.println("\n\n\t\t Please wait while your transaction is being processing....\n");
            TimeUnit.SECONDS.sleep(10);
            balance -= amount;
            System.out.println(BLUE + "\n\n\t\t*" + RED + " - ₹ " + amount + BLUE + " Withdrawn Successfully from " + YELLOW + accHolder + BLUE + "'s account ☹️ ☹️ *" + RESET);
            System.out.println(BLUE + "\n\n\t\t\t* Thank you for trusting us. See you soon 🤗🤗 *" + RESET);
        } 
        else {
            System.out.println(RED + "\n\t\t!!!! 😕 Invalid withdrawal amount or insufficient balance 😕 !!!!" + RESET);
        }
    }
}

class BankApp {
    public static void main(String[] args) throws InterruptedException {
        Console c = System.console();
        char[] ch;

        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String BLUE = "\u001B[34m";
        
        withdrawDeposit[] accounts = new withdrawDeposit[3]; // Create an array to store multiple accounts
        initializeAccounts(accounts); // Initialize accounts

        try (Scanner sc = new Scanner(System.in)) {
            while(true){
                System.out.println("\n\n\t\t🤗 🤗 🤑  Welcome in our পকেট মেরে টাকা জমাও Bank  🤑 🤗 🤗");
                System.out.println("\n\t\t\t\t1. For deposit");
                System.out.println("\n\t\t\t\t2. For withdraw");
                System.out.println("\n\t\t\t\t3. For Enquiry");
                System.out.println("\n\t\t\t\t4. For Quit");
                System.out.print("\n\t\t\tEnter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("\n\t\tEnter the account number for deposit: ");
                        long accountNumber = sc.nextLong();
                        int accountIndex = findAccount(accounts, accountNumber);
                        if (accountIndex != -1) {
                            System.out.print("\n\t\tEnter the amount you want to deposit: ");
                            double amount = sc.nextDouble();
                            accounts[accountIndex].deposit(amount);
                        } 
                        else {
                            System.out.println(RED + "\n\t\t!!!!! 😢 😥 😔 Account not found 😔 😥 😢 !!!!!\n" + RESET);
                        }
                        break;

                    case 2:
                        System.out.print("\n\t\tEnter the account number for withdrawal: ");
                        accountNumber = sc.nextLong();
                        accountIndex = findAccount(accounts, accountNumber);
                        if (accountIndex != -1) {
                            System.out.print("\n\t\tEnter the amount you want to withdraw: ");
                            double amount = sc.nextDouble();
                            System.out.print("\n\t\tHi " + BLUE + accounts[accountIndex].accHolder + RESET + ", Please enter your Password: ");
                            ch = c.readPassword();
                            String pass = String.valueOf(ch);
                            if (pass.equals(accounts[accountIndex].password)) {
                                accounts[accountIndex].withdraw(amount);
                            }
                            else {
                                System.out.println(RED + "\n\t\t!!!!! 😢 😥 😔 Password not correct 😔 😥 😢 !!!!!\n" + RESET);
                                break;
                            }
                        } 
                        else {
                            System.out.println(RED + "\n\t\t!!!!! 😢 😥 😔 Account not found 😔 😥 😢 !!!!!\n" + RESET);
                        }
                        break;

                    case 3:
                        System.out.print("\n\t\tEnter the account number for enquiry: ");
                        accountNumber = sc.nextLong();
                        int found = 0; // Add a variable to keep track of whether an account was found

                        for (withdrawDeposit account : accounts) {
                            if (account.accNo == accountNumber) {
                                System.out.print("\n\t\tHi " + BLUE + account.accHolder + RESET + ", Please enter your Password: ");
                                ch = c.readPassword();
                                String pass = String.valueOf(ch);
                                if (pass.equals(account.password)) {
                                    System.out.println("\n\t\tCurrent Account Information & Status:\n");
                                    account.displayAccountInfo();
                                    found = 1; // Set the variable to indicate that the account was found
                                }
                                else{
                                    System.out.println(RED + "\n\t\t!!!!! 😢 😥 😔 Wrong Password 😔 😥 😢 !!!!!\n" + RESET);
                                    continue;
                                }
                            }
                        }

                        if (found == 0) {
                            System.out.println(RED + "\n\t\t!!!!! 😢 😥 😔 Account not found 😔 😥 😢 !!!!!\n" + RESET);
                        }
                        break;
                    
                    case 4:
                        System.out.println();
                        System.exit(0);

                    default:
                        System.out.println(RED + "\n\t\t!!!!! Your choice is invalid ❌ !!!!!\n" + RESET);
                        break;
                }
            }
        }
    }

    // public static void initializeAccounts(withdrawDeposit[] accounts) {
        accounts[0] = new withdrawDeposit(123456789, "Anit Halder","anit...223", 10000);
        accounts[1] = new withdrawDeposit(987654321, "Arpan Mitra","arpan@123", 5000);
        accounts[2] = new withdrawDeposit(222222222, "Subhajit Sardar","subhajit123", 8000);
    }

    public static int findAccount(withdrawDeposit[] accounts, long accountNumber) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].accNo == accountNumber) {
                return i;
            }
        }
        return -1; // Account not found
    }
}
