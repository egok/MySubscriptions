package dataTypes;

import java.util.ArrayList;
import java.util.Set;

import model.TransactionEvent;

public interface TransactionEvents extends Set<TransactionEvent>{

	public ArrayList<TransactionEvent> getAllTEvents();
	public ArrayList<TransactionEvent> getOnlyOutTransactionEvents();
	public boolean doesOutTransactionEventsExist();
	public void add(ArrayList<TransactionEvent> tEvents);
}
