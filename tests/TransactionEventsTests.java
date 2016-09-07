

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dataTypes.TransactionEvents;
import dataTypesImpl.TransactionEventsImpl;
import dataTypes.TransactionEvent;
import dataTypesImpl.TransactionEventImpl;
import model.TransactionEventsHandler;

public class TransactionEventsTests {

	
	
	
	
	private TransactionEvents myTEvents;

	// For 2.a. requirement
	@Test
	public void getOnlyOutTransactions() {
		myTEvents = new TransactionEventsImpl();
		myTEvents.addAll(actAsDataProvider());
		assertEquals(8, TransactionEventsHandler
				.getOnlyOutTransactionEvents(myTEvents)
				.size());
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
