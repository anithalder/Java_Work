import java.util.Scanner;

class BankAccount {
    long accNo;
    String accHolder;
    double balance;

    public BankAccount(long accNo, String accHolder, double balance) {
        this.accHolder = accHolder;
        this.accNo = accNo;
        this.balance = balance;
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accNo);
        System.out.println("Account Holder: " + accHolder);
        System.out.println("Balance: ₹" + balance + "\n");
    }
}

class withdrawDeposit extends BankAccount{
    public withdrawDeposit(long accNo, String accHolder, double balance) {
        super(accNo, accHolder, balance);
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
        withdrawDeposit[] accounts = new withdrawDeposit[3]; // Create an array to store multiple accounts
        initializeAccounts(accounts); // Initialize accounts

        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t\t🤗 🤗 🤑  Welcome in our পোঁদ মেরে টাকা জমাও ব্যাঙ্ক Bank  🤑 🤗 🤗");

        while(true){
            System.out.println("\t\t\n1. For deposit");
            System.out.println("\t\t\n2. For withdraw");
            System.out.println("\t\t\n3. For Enquiry");
            System.out.println("\t\t\n4. For Quit");
            System.out.print("\t\nEnter your choice: ");
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
                    } else {
                        System.out.println("\n\t\t!!!!! 😢 😥 😔 Account not found 😔 😥 😢 !!!!!\n");
                    }
                    break;

                case 2:
                    System.out.print("Enter the account number for withdrawal: ");
                    accountNumber = sc.nextLong();
                    accountIndex = findAccount(accounts, accountNumber);
                    if (accountIndex != -1) {
                        System.out.print("Enter the amount you want to withdraw: ");
                        double amount = sc.nextDouble();
                        accounts[accountIndex].withdraw(amount);
                    } 
                    else {
                        System.out.println("\n\t\t!!!!! 😢 😥 😔 Account not found 😔 😥 😢 !!!!!\n");
                    }
                    break;

                case 3:
                    System.out.print("Enter the account number for enquiry: ");
                    accountNumber = sc.nextLong();
                
                    for (withdrawDeposit account : accounts) {
                        if (account.accNo == accountNumber) {
                            System.out.println("\nCurrent Account Information & Status:\n");
                            account.displayAccountInfo();
                        }
                        else {
                            System.out.println("\n\t\t!!!!! 😢 😥 😔 Account not found 😔 😥 😢 !!!!!\n");
                            break;
                        }
                    }
                    break;
                
                case 4:
                    System.exit(0);

                default:
                    System.out.println("\n\t\t!!!!! Your choice is invalid ❌ !!!!!\n");
                    break;
            }
        }
    }

    public static void initializeAccounts(withdrawDeposit[] accounts) {
        accounts[0] = new withdrawDeposit(123456789, "Anit Halder", 10000);
        accounts[1] = new withdrawDeposit(987654321, "Arpan Mitra", 5000);
        accounts[2] = new withdrawDeposit(555555555, "Subhajit Sardar", 8000);
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
