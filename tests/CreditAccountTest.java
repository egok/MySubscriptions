import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.TransactionEvent;
import modelImpl.CreditAccountImpl;
import modelImpl.TransactionEventImpl;

public class CreditAccountTest {

private CreditAccountImpl myAccount;
	
	// For requirement 3.a
	@Test
	public void getBalance() {
		myAccount = new CreditAccountImpl();
		
		for(TransactionEvent tEvent: actAsDataProvider()){myAccount.addEvent(tEvent);}
		
		assertEquals(myAccount.getBalance(),-460,0);
	}
	
	// TODO: Change it to data provider
	private ArrayList<TransactionEvent> actAsDataProvider(){
		ArrayList<TransactionEvent> te = new ArrayList<>();
		te.add(TransactionEventImpl
		.teventBuilder()
		.amount(-10)
		.dateOfTransaction(1473187532)
		.textDescription("PewaBiWeekly")
		.build());
		te.add(TransactionEventImpl
				.teventBuilder()
				.amount(-20)
				.dateOfTransaction(1472582732)
				.textDescription("PewaMonthly")
				.build());
		te.add(TransactionEventImpl
				.teventBuilder()
				.amount(-30)
				.dateOfTransaction(1471977932)
				.textDescription("PewaBiWeekly")
				.build());
		te.add(TransactionEventImpl
				.teventBuilder()
				.amount(-40)
				.dateOfTransaction(1470163532)
				.textDescription("PewaMonthly")
				.build());
		te.add(TransactionEventImpl
				.teventBuilder()
				.amount(-50)
				.dateOfTransaction(12345)
				.textDescription("Pewb")
				.build());
		te.add(TransactionEventImpl
				.teventBuilder()
				.amount(-60)
				.dateOfTransaction(1467744332)
				.textDescription("PewaMonthly")
				.build());
		te.add(TransactionEventImpl
				.teventBuilder()
				.amount(-70)
				.dateOfTransaction(12345)
				.textDescription("Pewc")
				.build());
		te.add(TransactionEventImpl
				.teventBuilder()
				.amount(-80)
				.dateOfTransaction(12345)
				.textDescription("Pewd")
				.build());
		te.add(TransactionEventImpl
				.teventBuilder()
				.amount(-90)
				.dateOfTransaction(12345)
				.textDescription("Pewe")
				.build());
		te.add(TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(12345)
				.textDescription("Pewf")
				.build());
		return te;
	}
}
