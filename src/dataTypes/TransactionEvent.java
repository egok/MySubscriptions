package dataTypes;

public interface TransactionEvent {
	
	// long is being used instead of date. Oh that java.util.Date is so damn expensive to use.
	public long getDate();
	public String getText();
	public String getEventType();
	public Double getAmount();
	public String getRecepientNumber();
}
