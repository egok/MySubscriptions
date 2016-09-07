package dataTypes;

import java.util.ArrayList;
import model.TransactionEvent;

public interface TransactionEvents{

	public ArrayList<TransactionEvent> getAllTEvents();
	public ArrayList<TransactionEvent> getOnlyOutTransactionEvents();
	public boolean doesOutTransactionEventsExist();
	public void add(ArrayList<TransactionEvent> tEvents);
	public void add(TransactionEvent tEvent);
}
