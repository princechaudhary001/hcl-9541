package OOPS;

/** OOP pillar 1: Encapsulation - private data + public getters/setters with validation. */
public class Encapsulation {
    static class BankAccount {
        private final String accountNo;
        private double balance;

        BankAccount(String accountNo, double openingBalance) {
            this.accountNo = accountNo;
            this.balance = Math.max(openingBalance, 0);
        }

        public double getBalance() { return balance; }
        public String getAccountNo() { return accountNo; }

        public void deposit(double amt) {
            if (amt <= 0) throw new IllegalArgumentException("Deposit must be positive");
            balance += amt;
        }

        public boolean withdraw(double amt) {
            if (amt <= 0 || amt > balance) return false;
            balance -= amt;
            return true;
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-101", 1000);
        acc.deposit(500);
        System.out.println("After deposit: " + acc.getBalance());
        System.out.println("Withdraw 2000 ok? " + acc.withdraw(2000));
        System.out.println("Withdraw 300 ok?  " + acc.withdraw(300));
        System.out.println("Final balance: " + acc.getBalance());
        // acc.balance = 1_000_000;   // compile error: balance has private access
    }
}
