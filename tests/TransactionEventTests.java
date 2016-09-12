import static org.junit.Assert.*;

import org.junit.Test;

import dataTypes.TransactionEvent;
import dataTypesImpl.TransactionEventImpl;
public class TransactionEventTests {
	
	@Test
	public void testBuildWithDate() {
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.dateOfTransaction(1473187532)
				.build();
		
		assertEquals(1473187532, tEvent.getDate(), 0);
	}
	
	@Test
	public void testBuildWithDescription() {
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.textDescription("PewaBiWeekly")
				.build();
		
		assertEquals("PewaBiWeekly", tEvent.getText());
	}
	
	@Test
	public void testBuildWithEventType() {
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.eventType("SomeEvent")
				.build();
		
		assertEquals("SomeEvent", tEvent.getEventType());
	}
	
	@Test
	public void testBuildWithAmountPositiveNumber() {
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.amount(10.27)
				.build();
		
		assertEquals(10.27, tEvent.getAmount(), 0);
	}
	
	@Test
	public void testBuildWithAmountNegetiveNumber() {
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.amount(-10.42356478373)
				.build();
		
		assertEquals(-10.42356478373, tEvent.getAmount(), 0);
	}
	
	@Test
	public void testBuildWithRecepientNumber() {
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.recepientNumber("123-456-789")
				.build();
		
		assertEquals("123-456-789", tEvent.getRecepientNumber());
	}
	
	@Test
	public void testCompareSameDate(){
		TransactionEventImpl tEvent = (TransactionEventImpl)TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeekly")
				.build();
		
		TransactionEventImpl tEventOther = (TransactionEventImpl)TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeekly")
				.build();
		
		assertEquals(0, tEvent.compareTo(tEventOther));
	}
	
	@Test
	public void testCompareDifferentDate(){
		TransactionEventImpl tEvent = (TransactionEventImpl)TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.dateOfTransaction(1473177532)
				.textDescription("PewaBiWeeklya")
				.build();
		
		TransactionEventImpl tEventOther = (TransactionEventImpl)TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeeklyb")
				.build();
		
		assertEquals(-1, tEvent.compareTo(tEventOther));
	}
	
	@Test
	public void testCompareDifferentDateReverse(){
		TransactionEventImpl tEvent = (TransactionEventImpl)TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeeklyB")
				.build();
		
		TransactionEventImpl tEventOther = (TransactionEventImpl)TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.dateOfTransaction(1473177532)
				.textDescription("PewaBiWeeklyA")
				.build();
		
		assertEquals(1, tEvent.compareTo(tEventOther));
	}
	
	@Test
	public void testEqualReturnsTrue(){
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeekly")
				.build();
		
		TransactionEvent tEventOther = TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.dateOfTransaction(1473187532)
				.textDescription("PewaBiWeekly")
				.build();
		
		assertTrue(tEvent.equals(tEventOther));
	}
	
	@Test
	public void testEqualReturnsTrueWithAmount(){
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.build();
		
		TransactionEvent tEventOther = TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.build();
		
		assertTrue(tEvent.equals(tEventOther));
	}
	
	@Test
	public void testEqualReturnsFalseWithAmount(){
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.amount(-11)
				.build();
		
		TransactionEvent tEventOther = TransactionEventImpl
				.tEventBuilder()
				.amount(-10)
				.build();
		
		assertFalse(tEvent.equals(tEventOther));
	}
	
	@Test
	public void testEqualReturnsTrueWithEventType(){
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.eventType("SomeEvent")
				.build();
		
		TransactionEvent tEventOther = TransactionEventImpl
				.tEventBuilder()
				.eventType("SomeEvent")
				.build();
		
		assertTrue(tEvent.equals(tEventOther));
	}
	
	@Test
	public void testEqualReturnsFalseWithEventType(){
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.eventType("SomeEvent")
				.build();
		
		TransactionEvent tEventOther = TransactionEventImpl
				.tEventBuilder()
				.eventType("OtherEvent")
				.build();
		
		assertFalse(tEvent.equals(tEventOther));
	}
	
	@Test
	public void testEqualReturnsTrueWithDateOfTransaction(){
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.dateOfTransaction(1473187532)
				.build();
		
		TransactionEvent tEventOther = TransactionEventImpl
				.tEventBuilder()
				.dateOfTransaction(1473187532)
				.build();
		
		assertTrue(tEvent.equals(tEventOther));
	}
	
	@Test
	public void testEqualReturnsFalseWithDateOfTransaction(){
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.dateOfTransaction(1473187531)
				.build();
		
		TransactionEvent tEventOther = TransactionEventImpl
				.tEventBuilder()
				.dateOfTransaction(1473187532)
				.build();
		
		assertFalse(tEvent.equals(tEventOther));
	}
	
	@Test
	public void testEqualReturnsTrueWithRecepientNumber(){
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.recepientNumber("1232")
				.build();
		
		TransactionEvent tEventOther = TransactionEventImpl
				.tEventBuilder()
				.recepientNumber("1232")
				.build();
		
		assertTrue(tEvent.equals(tEventOther));
	}
	
	@Test
	public void testEqualReturnsFalseWithRecepientNumber(){
		TransactionEvent tEvent = TransactionEventImpl
				.tEventBuilder()
				.recepientNumber("1232")
				.build();
		
		TransactionEvent tEventOther = TransactionEventImpl
				.tEventBuilder()
				.recepientNumber("12322")
				.build();
		
		assertFalse(tEvent.equals(tEventOther));
	}
}
