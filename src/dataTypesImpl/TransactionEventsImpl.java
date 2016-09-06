package dataTypesImpl;

import java.util.ArrayList;

import dataTypes.TransactionEvents;
import model.TransactionEvent;

public class TransactionEventsImpl implements TransactionEvents{

	private ArrayList<TransactionEvent> myTEvents;
	private ArrayList<TransactionEvent> myOutGoingTEvents = new ArrayList<>();
	
	public TransactionEventsImpl(){
		myTEvents = new ArrayList<>();
	}
	
	public TransactionEventsImpl(ArrayList<TransactionEvent> tEvents) {
		myTEvents = tEvents;
	}

	public void add(ArrayList<TransactionEvent> tEvents) {
		myTEvents.addAll(tEvents);
	}

	public void add(TransactionEvent tEvent) {
		myTEvents.add(tEvent);
	}

	@Override
	public ArrayList<TransactionEvent> getOnlyOutTransactionEvents() {
		for(TransactionEvent tEvent : myTEvents){
			if(tEvent.getAmount()<0) myOutGoingTEvents.add(tEvent);
		}
		return myOutGoingTEvents;
	}

	@Override
	public boolean doesOutTransactionEventsExist() {
		return !myOutGoingTEvents.isEmpty();
	}

	@Override
	public ArrayList<TransactionEvent> getAllTEvents() {
		return myTEvents;
	}
}
