package dataTypesImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import dataTypes.TransactionEvents;
import dataTypes.TransactionEvent;

public class TransactionEventsImpl implements TransactionEvents{

	protected Set<TransactionEvent> myTEventsSet = new HashSet<TransactionEvent>();

//	@Override
//	public ArrayList<TransactionEvent> getOnlyOutTransactionEvents() {
//		for(TransactionEvent tEvent : myTEvents){
//			if(tEvent.getAmount()<0) myOutGoingTEvents.add(tEvent);
//		}
//		return myOutGoingTEvents;
//	}
//
//	@Override
//	public boolean doesOutTransactionEventsExist() {
//		return !myOutGoingTEvents.isEmpty();
//	}

	@Override
	public int size() {
		return myTEventsSet.size();
	}

	@Override
	public boolean isEmpty() {
		return myTEventsSet.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return myTEventsSet.contains(o);
	}

	@Override
	public Iterator<TransactionEvent> iterator() {
		return myTEventsSet.iterator();
	}

	@Override
	public Object[] toArray() {
		return myTEventsSet.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return myTEventsSet.toArray(a);
	}

	@Override
	public boolean add(TransactionEvent e) {
		return myTEventsSet.add(e);
	}

	@Override
	public boolean remove(Object o) {
		return myTEventsSet.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return myTEventsSet.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends TransactionEvent> c) {
		return myTEventsSet.addAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return myTEventsSet.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return myTEventsSet.removeAll(c);
	}

	@Override
	public void clear() {
		myTEventsSet.clear();
	}
}
