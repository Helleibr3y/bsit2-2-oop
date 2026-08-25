package atm;

public class CheckingAccount extends Account {

    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String ownerName, double openingBalance, double overdraftLimit) {
        super(accountNumber, ownerName, openingBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getAccountType() {
        return "CHECKING";
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0.");
        }
        if ((getBalance() - amount) < -overdraftLimit) {
            double shortfall = amount - (getBalance() + overdraftLimit);
            throw new InsufficientFundsException(shortfall);
        }
        applyWithdrawal(amount);
    }
}

/*
1.getAccountType() is declared abstract in atm.Account because an atm.Account is a generic base class,
and every subclass (Savings, Checking) must define its own specific identity.
2.atm.SavingsAccount can call super.withdraw() and applyWithdrawal() because they are public/protected
methods inherited from atm.Account. Therefore, it cannot access the 'balance' field directly because
'balance' is marked 'private' in atm.Account, restricting direct access individually to the atm.Account class.
*/

