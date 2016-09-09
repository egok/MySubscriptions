package model;

import dataTypes.TransactionEvent;
import dataTypes.TransactionEvents;
/*
 * Public interface for the account information to reflect different Transactions
 */
public interface Account{
	
	TransactionEvents getEvents();
	void addEvent(TransactionEvent transactionEvent);
	double getBalance();
	int getTransactionsCount();

}
