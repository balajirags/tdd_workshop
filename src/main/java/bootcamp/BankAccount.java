package bootcamp;

public class BankAccount {

    public static final int MIN_BALANCE = 500;
    private int balance;

    public BankAccount(int minBalance) throws Exception {
        if (minBalance < MIN_BALANCE) {
            throw new Exception(ErrorConstants.NO_MIN_BALANCE);
        }
        balance = minBalance;
    }

    public void withDraw(int amount) throws Exception {
        if (balance < amount) {
            throw new Exception(ErrorConstants.IN_SUFFICIENT_BALANCE);
        }

        balance -= amount;
    }


    public int getBalance() {
        return balance;
    }

    public void transfer(int amountToTransfer, BankAccount destinationAccount) throws Exception {
        withDraw(amountToTransfer);
    }
}
