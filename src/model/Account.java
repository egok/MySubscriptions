package model;

import dataTypes.TransactionEvent;
import dataTypes.TransactionEvents;
/*
 * Public interface for the account information to reflect different Transactions
 */
public interface Account{
	
	public TransactionEvents getEvents();
	public void addEvent(TransactionEvent transactionEvent);
	public double getBalance();
	public int getTransactionsCount();

}
