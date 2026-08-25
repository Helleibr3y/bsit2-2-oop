package atm;

public class ATMService {

    // Overloading
    public void deposit(Account account, double amount) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f%n", amount);
    }

    public void deposit(Account account, double amount, String note) {
        account.deposit(amount);
        System.out.printf("Deposited PHP %.2f. Note: %s%n", amount, note);
    }

    // Varargs
    public double depositAll(Account account, double... amounts) {
        double total = 0;
        for (double amt : amounts) {
            account.deposit(amt);
            total += amt;
        }
        return total;
    }

    // Pass-by-value demonstration
    public void tryToReplace(Account account) {
        account = new SavingsAccount("XX-000", "Ghost atm.Account", 0, 0);
        System.out.println("Inside the method  : " + account);
        /* Java passes object reference variables by value (a copy of the reference).
          Reassigning 'account' inside of this method only changes the local copy variable to point
          to a new object, leaving the caller's reference in main() pointing to the original object.
         */
    }

    public void addBonus(Account account, double bonus) {
        account.deposit(bonus);
        /*
         * EXPLANATION: Even though the reference itself is passed by value, both the method's local
         * reference variable and main()'s variable point to the exact same object in heap memory.
         * Calling deposit() mutates the object's internal state, so changes remain visible in main().
         */
    }

    // Transfer
    public void transfer(Account from, Account to, double amount) throws InsufficientFundsException {
        from.withdraw(amount);
        to.deposit(amount);
    }
}


