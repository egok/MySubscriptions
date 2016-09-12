package modelImpl;

import dataTypes.TransactionEvents;
import dataTypesImpl.TransactionEventsImpl;
import model.Account;

import dataTypes.TransactionEvent;

// Simple account class
abstract class AccountImpl implements Account{

	private TransactionEvents myTEvents = new TransactionEventsImpl();
	private double myBalance = 0;

	@Override
	public TransactionEvents getEvents() {
		return myTEvents;
	}

	@Override
	public void addEvent(TransactionEvent transactionEvent) {
		myBalance += transactionEvent.getAmount();
		myTEvents.add(transactionEvent);
	}

	@Override
	public double getBalance() {
		return myBalance;
	}

	@Override
	public int getTransactionsCount() {
		return myTEvents.size();
	}
}
