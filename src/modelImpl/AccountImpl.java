package modelImpl;

import java.util.ArrayList;
import java.util.HashMap;

import dataTypes.TransactionEvents;
import dataTypesImpl.TransactionEventsImpl;
import model.Account;
import model.TransactionEvent;

abstract class AccountImpl implements Account{
	
	private TransactionEvents myTEvents = new TransactionEventsImpl();
	private double myBalance = 0;

	@Override
	public HashMap<String, ArrayList<Long>> getRecurringTransactions() {
		RecurranceDetectionEngineImpl rde = new RecurranceDetectionEngineImpl();
		return rde.getRecurringTransactions(myTEvents);
	}
	
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
		return myTEvents.getAllTEvents().size();
	}
}
