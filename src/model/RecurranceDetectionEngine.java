package model;

import java.util.ArrayList;
import java.util.HashMap;

import dataTypes.TransactionEvents;

public interface RecurranceDetectionEngine {
	public static final long THRESHOLD = 2; 
	public String getRecurringTransactions(String key, TransactionEvents tEvents);
	public HashMap<String, ArrayList<Long>> getRecurringTransactions(TransactionEvents tEvents);
}