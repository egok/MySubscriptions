package model;

import dataTypes.TransactionEvent;
import dataTypes.TransactionEvents;
import dataTypesImpl.TransactionEventsImpl;

public interface TransactionEventsHandler {
	//Given TransactionEvents object with positive (in) Transactions and negative (out) Transactions,
	// it returns TransactionEvents with only negative Transactions
	static TransactionEvents getOnlyOutTransactionEvents(TransactionEvents tEvents) {
		TransactionEvents myOutGoingTEvents = new TransactionEventsImpl();
		for(TransactionEvent tEvent : tEvents){
			if(tEvent.getAmount()<0) myOutGoingTEvents.add(tEvent);
		}
		return myOutGoingTEvents;
	}
}
