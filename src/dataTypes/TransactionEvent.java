package dataTypes;

public interface TransactionEvent {
	long getDate();
	String getText();
	String getEventType();
	Double getAmount();
	String getRecepientNumber();
}
