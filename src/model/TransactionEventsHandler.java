package model;

import java.util.Set;

import dataTypes.TransactionEvent;
import dataTypes.TransactionEvents;
import dataTypesImpl.TransactionEventsImpl;

public interface TransactionEventsHandler {
	static Set<TransactionEvent> getOnlyOutTransactionEvents(Set<TransactionEvent> tEvents) {
		TransactionEvents myOutGoingTEvents = new TransactionEventsImpl();
		for(TransactionEvent tEvent : tEvents){
			if(tEvent.getAmount()<0) myOutGoingTEvents.add(tEvent);
		}
		return myOutGoingTEvents;
	}
}
