package dataTypes;

public interface TransactionEvent {
	
	// long is being used instead of date. Oh that java.util.Date is so damn expensive to use.
	long getDate();
	String getText();
	String getEventType();
	Double getAmount();
	String getRecepientNumber();
}
