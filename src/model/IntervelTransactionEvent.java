package model;

import java.util.List;

public interface IntervelTransactionEvent extends TransactionEvent{

	public TransactionEvent getnext();
	public List<Long> getTransactionDates();
	
}