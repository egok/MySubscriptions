import static org.junit.Assert.*;

import org.junit.Test;

import dataTypes.TransactionEvent;
import dataTypesImpl.TransactionEventImpl;
public class TransactionEventTests {
	
	@Test
	public void testBuildWithDate() {
		TransactionEvent tEvent = TransactionEventImpl
				.teventBuilder()
				.dateOfTransaction(1473187532)
				.build();
		
		assertEquals(1473187532, tEvent.getDate(), 0);
	}
	
	@Test
	public void testBuildWithDescription() {
		TransactionEvent tEvent = TransactionEventImpl
				.teventBuilder()
				.textDescription("PewaBiWeekly")
				.build();
		
		assertEquals("PewaBiWeekly", tEvent.getText());
	}
	
	@Test
	public void testBuildWithEventType() {
		TransactionEvent tEvent = TransactionEventImpl
				.teventBuilder()
				.eventType("SomeEvent")
				.build();
		
		assertEquals("SomeEvent", tEvent.getEventType());
	}
	
	@Test
	public void testBuildWithAmountPositiveNumber() {
		TransactionEvent tEvent = TransactionEventImpl
				.teventBuilder()
				.amount(10.27)
				.build();
		
		assertEquals(10.27, tEvent.getAmount(), 0);
	}
	
	@Test
	public void testBuildWithAmountNegetiveNumber() {
		TransactionEvent tEvent = TransactionEventImpl
				.teventBuilder()
				.amount(-10.42356478373)
				.build();
		
		assertEquals(-10.42356478373, tEvent.getAmount(), 0);
	}
	
	@Test
	public void testBuildWithRecepientNumber() {
		TransactionEvent tEvent = TransactionEventImpl
				.teventBuilder()
				.recepientNumber("123-456-789")
				.build();
		
		assertEquals("123-456-789", tEvent.getRecepientNumber());
	}
	
	@Test
	public void testCompareSameDate(){
		TransactionEventImpl tEvent = (TransactionEventImpl)TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeekly")
				.build();
		
		TransactionEventImpl tEventOther = (TransactionEventImpl)TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeekly")
				.build();
		
		assertEquals(0, tEvent.compareTo(tEventOther));
	}
	
	@Test
	public void testCompareDifferentDate(){
		TransactionEventImpl tEvent = (TransactionEventImpl)TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(1473177532)
				.textDescription("PewaBiWeeklya")
				.build();
		
		TransactionEventImpl tEventOther = (TransactionEventImpl)TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeeklyb")
				.build();
		
		assertEquals(-1, tEvent.compareTo(tEventOther));
	}
	
	@Test
	public void testCompareDifferentDateReverse(){
		TransactionEventImpl tEvent = (TransactionEventImpl)TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeeklyB")
				.build();
		
		TransactionEventImpl tEventOther = (TransactionEventImpl)TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(1473177532)
				.textDescription("PewaBiWeeklyA")
				.build();
		
		assertEquals(1, tEvent.compareTo(tEventOther));
	}
	
	@Test
	public void testEqualReturnsTrue(){
		TransactionEvent tEvent = TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeekly")
				.build();
		
		TransactionEvent tEventOther = TransactionEventImpl
				.teventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeekly")
				.build();
		
		assertTrue(tEvent.equals(tEventOther));
	}
	
}
