class Bank_Account {
    private long accountNumber;
    protected double balance;

    public Bank_Account(long accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount + "\n");
        } else {
            System.out.println("Invalid deposit amount.\n");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.\n");
        }
    }

    public void displayBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance + "\n");
    }
}

class SavingsAccount extends Bank_Account {
    public SavingsAccount(int accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= 100) {
            balance -= amount;
            System.out.println("Withdrawn from Savings: $" + amount + "\n");
        } else {
            System.out.println("Invalid withdrawal amount or minimum balance requirement not met.\n");
        }
    }
}

class CheckingAccount extends Bank_Account {
    public CheckingAccount(int accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -100) {
            balance -= amount;
            System.out.println("Withdrawn from Checking: $" + amount + "\n");
        } else {
            System.out.println("Invalid withdrawal amount or overdraft limit reached.\n");
        }
    }
}

class BankOverride {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(2001, 500);
        CheckingAccount checkingAccount = new CheckingAccount(2002, 200);

        savingsAccount.displayBalance();
        savingsAccount.withdraw(50);
        savingsAccount.displayBalance();

        checkingAccount.displayBalance();
        checkingAccount.withdraw(250);
        checkingAccount.displayBalance();
    }
}
