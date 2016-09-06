import static org.junit.Assert.*;

import org.junit.Test;

import model.Account;
import modelImpl.*;

public class AccountTests {

	private Account myAccount;
	private static final double OFFSET = 0;
	
	
	@Test
	public void addAnEvent() {
		myAccount = new BankAccountImpl();
		myAccount.addEvent(TransactionEventImpl
				.teventBuilder()
				.amount(-20)
				.dateOfTransaction(12345)
				.textDescription("Mew")
				.build());
		assertEquals(myAccount.getTransactionsCount(), 1L);
	}
	
	@Test
	public void getAnEvent() {
		myAccount = new BankAccountImpl();
		myAccount.addEvent(TransactionEventImpl
				.teventBuilder()
				.amount(-20)
				.dateOfTransaction(12345)
				.textDescription("Mew")
				.build());
		assertNotNull(myAccount.getTransactionsCount());
	}
	
	@Test
	public void getBalance() {
		myAccount = new BankAccountImpl();
		myAccount.addEvent(TransactionEventImpl
				.teventBuilder()
				.amount(0)
				.dateOfTransaction(12345)
				.textDescription("Mew")
				.build());
		assertEquals(myAccount.getBalance(), 0, OFFSET);
	}
	
	@Test
	public void getBalanceChange() {
		myAccount = new BankAccountImpl();
		myAccount.addEvent(TransactionEventImpl
				.teventBuilder()
				.amount(-20)
				.dateOfTransaction(12345)
				.textDescription("Mew")
				.build());
		assertEquals(myAccount.getBalance(), -20, OFFSET);
	}
}
