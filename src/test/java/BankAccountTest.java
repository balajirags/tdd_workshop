import bootcamp.BankAccount;
import bootcamp.MessageSender;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BankAccountTest {


    public static final int INITIAL_AMOUT = 500;
    private MessageSender messageSender;

    @Before
    public void setup(){
        messageSender = mock(MessageSender.class);
    }

    @Test
    public void shouldBeAbleToCreateAccountWithMinBalance() throws Exception {
        BankAccount bankAccount = new BankAccount(INITIAL_AMOUT);
        assertTrue(true);
    }

    @Test
    public void shouldNotCreateAnAccountWhichIsLessThanMinBalance() {
        try {
            BankAccount bankAccount = new BankAccount(200);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test(expected = Exception.class)
    public void shouldNotBeAbleToWithDrawWithInsufficientBalance() throws Exception {
        BankAccount bankAccount = new BankAccount(600);
        bankAccount.withDraw(1200);
    }

    @Test
    public void shouldBeAbleToWithDraw() throws Exception {
        BankAccount bankAccount = new BankAccount(600);
        bankAccount.withDraw(200);
        int expectedBalance = 400;
        assertThat(bankAccount.getBalance(), Is.is(expectedBalance));
    }

    @Test(expected = Exception.class)
    public void shouldNotAllowTranferToAnotherAccountIfBalanceIsInsufficient() throws Exception {
        BankAccount sandhyAccount = new BankAccount(600);
        BankAccount waseemAccount = new BankAccount(1200);
        int amountToTransfer = 1400;
        sandhyAccount.transfer(amountToTransfer, waseemAccount);

    }

    @Test
    public void shouldSendSMSOnWithDrawal() throws Exception {
        BankAccount bankAccount = new BankAccount(1000);
        bankAccount.updateMessageSender(messageSender);
        bankAccount.withDraw(400);
        verify(messageSender).send();
    }


}
