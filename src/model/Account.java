package model;

import java.util.ArrayList;
import java.util.HashMap;
import dataTypes.TransactionEvents;
/*
 * Public interface for the account information to reflect different Transactions
 */
public interface Account{
	
	public TransactionEvents getEvents();
	public void addEvent(TransactionEvent transactionEvent);
	public double getBalance();
	public HashMap<String, ArrayList<Long>> getRecurringTransactions();
	
	// Long should be used
	public int getTransactionsCount();
}
