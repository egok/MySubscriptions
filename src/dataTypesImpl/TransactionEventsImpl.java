package dataTypesImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<TransactionEvent> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(TransactionEvent e) {
		myTEvents.add(e);
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends TransactionEvent> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
}
