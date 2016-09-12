import static org.junit.Assert.*;

import org.junit.Test;

import dataTypes.TransactionEvent;
import dataTypes.TransactionEvents;
import dataTypesImpl.TransactionEventImpl;
import dataTypesImpl.TransactionEventsImpl;
import model.TransactionEventsHandler;

public class TransactionEventsHandlerTest {

	private TransactionEvents myTEvents;

	// For 2.a. requirement
	@Test
	public void getOnlyOutTransactions() {
		myTEvents = actAsDataProvider();
		assertEquals(8, TransactionEventsHandler
				.getOnlyOutTransactionEvents(myTEvents)
				.size());
	}
	
	@Test
	public void testForEquals() {
		TransactionEvent e1 = TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeekly")
				.build();
		TransactionEvent e2 = TransactionEventImpl
				.teventBuilder()
				.amount(-20)
				.dateOfTransaction(1472582732)
				.textDescription("PewaMonthly")
				.build();
		TransactionEvent e3 = TransactionEventImpl
				.teventBuilder()
				.amount(-30)
				.dateOfTransaction(1471977932)
				.textDescription("PewaBiWeekly")
				.build();
		assertFalse(e1.equals(e2));
		assertFalse(e3.equals(e2));
		assertFalse(e1.equals(e3));
	}
	
	
	
	// TODO: Change it to data provider
	private TransactionEvents actAsDataProvider(){
		TransactionEvents te = new TransactionEventsImpl();
		TransactionEvent e;
		e = TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeekly")
				.build();
		assertFalse(te.contains(e));
		te.add(e);
		e = TransactionEventImpl
				.teventBuilder()
				.amount(-20)
				.dateOfTransaction(1472582732)
				.textDescription("PewaMonthly")
				.build();
		assertFalse(te.contains(e));
		te.add(e);
		e = TransactionEventImpl
				.teventBuilder()
				.amount(-30)
				.dateOfTransaction(1471977932)
				.textDescription("PewaBiWeekly")
				.build();
		assertFalse(te.contains(e));
		te.add(e);
		e = TransactionEventImpl
				.teventBuilder()
				.amount(-40)
				.dateOfTransaction(1470163532)
				.textDescription("PewaMonthly")
				.build();
		assertFalse(te.contains(e));
		te.add(e);
		e = TransactionEventImpl
				.teventBuilder()
				.amount(50)
				.dateOfTransaction(12345)
				.textDescription("Pewb")
				.build();
		assertFalse(te.contains(e));
		te.add(e);
		e = TransactionEventImpl
				.teventBuilder()
				.amount(60)
				.dateOfTransaction(1467744332)
				.textDescription("PewaMonthly")
				.build();
		assertFalse(te.contains(e));
		te.add(e);
		e = TransactionEventImpl
				.teventBuilder()
				.amount(-70)
				.dateOfTransaction(12345)
				.textDescription("Pewc")
				.build();
		assertFalse(te.contains(e));
		te.add(e);
		e = TransactionEventImpl
				.teventBuilder()
				.amount(-80)
				.dateOfTransaction(12345)
				.textDescription("Pewd")
				.build();
		assertFalse(te.contains(e));
		te.add(e);
		e = TransactionEventImpl
				.teventBuilder()
				.amount(-90)
				.dateOfTransaction(12345)
				.textDescription("Pewe")
				.build();
		assertFalse(te.contains(e));
		te.add(e);
		e = TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(12345)
				.textDescription("Pewf")
				.build();
		assertFalse(te.contains(e));
		te.add(e);
		return te;
	}
	
}