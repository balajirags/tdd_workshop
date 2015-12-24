package bootcamp;

public class BankAccount {

    public static final int MIN_BALANCE = 500;
    private int balance;
    private MessageSender messageSender;

    public BankAccount(int minBalance) throws Exception {
        if (minBalance < MIN_BALANCE) {
            throw new Exception(ErrorConstants.NO_MIN_BALANCE);
        }
        balance = minBalance;
    }

    public void updateMessageSender(MessageSender messageSender){
        this.messageSender = messageSender;
    }

    public void withDraw(int amount) throws Exception {
        if (balance < amount) {
            throw new Exception(ErrorConstants.IN_SUFFICIENT_BALANCE);
        }

        balance -= amount;

        messageSender.send();
    }


    public int getBalance() {
        return balance;
    }

    public void transfer(int amountToTransfer, BankAccount destinationAccount) throws Exception {
        withDraw(amountToTransfer);
    }
}
