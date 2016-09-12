import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import model.RecurranceDetectionEngine;
import dataTypes.TransactionEvent;
import modelImpl.BankAccountImpl;
import modelImpl.RecurranceDetectionEngineImpl;
import dataTypesImpl.TransactionEventImpl;

public class RecurranceDetectionEngineTest {
	RecurranceDetectionEngine rde;
	private BankAccountImpl myAccount;

	// For 4.a. requirement
	@Test
	public void getVideoStreamingRecurrance() {
		myAccount = new BankAccountImpl();
		rde = new RecurranceDetectionEngineImpl();
		for(TransactionEvent tEvent: actAsDataProvider()){myAccount.addEvent(tEvent);}
		
		assertEquals("Monthly", rde.getRecurringTransactions("Video streaming", myAccount.getEvents()));
	}
	
	// For 4.b. requirement
	@Test 
	public void getGymRecurrance() {
		myAccount = new BankAccountImpl();
		rde = new RecurranceDetectionEngineImpl();
		for(TransactionEvent tEvent: actAsDataProviderForGym()){myAccount.addEvent(tEvent);}
		
		assertEquals("BiWeekly", rde.getRecurringTransactions("Gym", myAccount.getEvents()));
	}
	
	// TODO: Change it to data provider
	private ArrayList<TransactionEvent> actAsDataProvider(){
		ArrayList<TransactionEvent> te = new ArrayList<>();
		te.add(TransactionEventImpl
		.tEventBuilder()
		.amount(-10)
		.dateOfTransaction(1473187532)
		.textDescription("PewaBiWeekly")
		.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-99)
				.dateOfTransaction(1472582732)
				.textDescription("Video streaming")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-30)
				.dateOfTransaction(1471977932)
				.textDescription("PewaBiWeekly")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-99)
				.dateOfTransaction(1470163532)
				.textDescription("Video streaming")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(50)
				.dateOfTransaction(12345)
				.textDescription("Pewb")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-99)
				.dateOfTransaction(1467744332)
				.textDescription("Video streaming")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-70)
				.dateOfTransaction(12345)
				.textDescription("Pewc")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-80)
				.dateOfTransaction(12345)
				.textDescription("Pewd")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-90)
				.dateOfTransaction(12345)
				.textDescription("Pewe")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.dateOfTransaction(12345)
				.textDescription("Pewf")
				.build());
		return te;
	}

	// TODO: Change it to data provider
	private ArrayList<TransactionEvent> actAsDataProviderForGym(){
		ArrayList<TransactionEvent> te = new ArrayList<>();
		
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeekly")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-20)
				.dateOfTransaction(1472582732)
				.textDescription("That thing")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-40)
				.dateOfTransaction(1466370800)
				.textDescription("This thing")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-200)
				.dateOfTransaction(1466380800)
				.textDescription("Gym")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-50)
				.dateOfTransaction(1467072000)
				.textDescription("Gym")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-30)
				.dateOfTransaction(1471977932)
				.textDescription("Other thing")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-200)
				.dateOfTransaction(1467590400)
				.textDescription("Gym")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(50)
				.dateOfTransaction(1467590400)
				.textDescription("Pewb")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-200)
				.dateOfTransaction(1468800000)
				.textDescription("Gym")
				.build());
		te.add(TransactionEventImpl
				.tEventBuilder()
				.amount(-200)
				.dateOfTransaction(1470009600)
				.textDescription("Gym")
				.build());
		return te;
	}
}
