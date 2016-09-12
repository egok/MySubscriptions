import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dataTypes.TransactionEvents;
import dataTypesImpl.TransactionEventImpl;
import dataTypesImpl.TransactionEventsImpl;

public class TransactionEventsTests {
	
	private TransactionEvents myTEvents;

	// For 2.a. requirement
	@Test
	public void testSizeOfTransactions() {
		myTEvents = actAsDataProvider();
		assertEquals(10, myTEvents.size());
	}
	
	// TODO: Change it to data provider
	private TransactionEvents actAsDataProvider(){
		TransactionEvents te = new TransactionEventsImpl();
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
				.amount(50)
				.dateOfTransaction(12345)
				.textDescription("Pewb")
				.build());
		te.add(TransactionEventImpl
				.teventBuilder()
				.amount(60)
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