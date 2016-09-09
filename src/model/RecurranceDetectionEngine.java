package model;

import java.util.ArrayList;
import java.util.HashMap;

import dataTypes.TransactionEvents;

public interface RecurranceDetectionEngine {
	static final long THRESHOLD = 2; 
	String getRecurringTransactions(String key, TransactionEvents tEvents);
	HashMap<String, ArrayList<Long>> getRecurringTransactions(TransactionEvents tEvents);
}