import java.util.Scanner;
import java.io.Console;

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
    public withdrawDeposit(long accNo, String accHolder, String password, double balance) {
        super(accNo, accHolder, password, balance);
        //TODO Auto-generated constructor stub
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\n\t\t* ₹ " + amount + " Deposited Successfully in " + accHolder + "'s account *");
        } 
        else {
            System.out.println("\t\t! Invalid deposit amount !");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\n\t\t* ₹ " + amount + " Withdrawn Successfully from " + accHolder + "'s account *");
        } 
        else {
            System.out.println("\n\t\t!!!! 😕 Invalid withdrawal amount or insufficient balance 😕 !!!!");
        }
    }
}

class BankApp {
    public static void main(String[] args) {
        Console c = System.console();
        
        withdrawDeposit[] accounts = new withdrawDeposit[3]; // Create an array to store multiple accounts
        initializeAccounts(accounts); // Initialize accounts

        try (Scanner sc = new Scanner(System.in)) {
            while(true){
                System.out.println("\n\n\t\t🤗 🤗 🤑  Welcome in our পোঁদ মেরে টাকা জমাও Bank  🤑 🤗 🤗");
                System.out.println("\n\t\t\t\t1. For deposit");
                System.out.println("\n\t\t\t\t2. For withdraw");
                System.out.println("\n\t\t\t\t3. For Enquiry");
                System.out.println("\n\t\t\t\t4. For Quit");
                System.out.print("\n\t\t\tEnter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter the account number for deposit: ");
                        long accountNumber = sc.nextLong();
                        int accountIndex = findAccount(accounts, accountNumber);
                        if (accountIndex != -1) {
                            System.out.print("Enter the amount you want to deposit: ");
                            double amount = sc.nextDouble();
                            accounts[accountIndex].deposit(amount);
                        } 
                        else {
                            System.out.println("\n\t\t!!!!! 😢 😥 😔 Account not found 😔 😥 😢 !!!!!\n");
                        }
                        break;

                    case 2:
                        System.out.print("\n\t\tEnter the account number for withdrawal: ");
                        accountNumber = sc.nextLong();
                        accountIndex = findAccount(accounts, accountNumber);
                        if (accountIndex != -1) {
                            System.out.print("\n\t\tEnter the amount you want to withdraw: ");
                            double amount = sc.nextDouble();
                            System.out.print("Hi," + accounts[accountIndex].accHolder + " Please enter your Password: ");
                            char[] ch = c.readPassword();
                            String pass = String.valueOf(ch);
                            if (pass.equals(accounts[accountIndex].password)) {
                                accounts[accountIndex].withdraw(amount);
                            }
                            else {
                                System.out.println("\n\t\t!!!!! 😢 😥 😔 Password not correct 😔 😥 😢 !!!!!\n");
                                break;
                            }
                        } 
                        else {
                            System.out.println("\n\t\t!!!!! 😢 😥 😔 Account not found 😔 😥 😢 !!!!!\n");
                        }
                        break;

                    case 3:
                        System.out.print("\n\t\tEnter the account number for enquiry: ");
                        accountNumber = sc.nextLong();
                         
                        for (withdrawDeposit account : accounts) {
                            if (account.accNo == accountNumber) {
                                System.out.print("\n\t\tHi," + account.accHolder + " Please enter your Password: ");
                                char[] ch = c.readPassword();
                                String pass = String.valueOf(ch);
                                if (pass.equals(account.password)) {
                                    System.out.println("\n\t\tCurrent Account Information & Status:\n");
                                    account.displayAccountInfo();
                                }
                                else {
                                    System.out.println("\n\t\t!!!!! 😢 😥 😔 Password not matched 😔 😥 😢 !!!!!\n");
                                    break;
                                }
                            }
                            else {
                                System.out.println("\n\t\t!!!!! 😢 😥 😔 Account not found 😔 😥 😢 !!!!!\n");
                                break;
                            }
                        }
                        break;
                    
                    case 4:
                        System.out.println();
                        System.exit(0);

                    default:
                        System.out.println("\n\t\t!!!!! Your choice is invalid ❌ !!!!!\n");
                        break;
                }
            }
        }
    }

    public static void initializeAccounts(withdrawDeposit[] accounts) {
        accounts[0] = new withdrawDeposit(123456789, "Anit Halder","anit...223", 10000);
        accounts[1] = new withdrawDeposit(987654321, "Arpan Mitra","arpan@123", 5000);
        accounts[2] = new withdrawDeposit(555555555, "Subhajit Sardar","subhajit123", 8000);
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
