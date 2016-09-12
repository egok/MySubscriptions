package model;

import dataTypes.TransactionEvents;

public interface RecurranceDetectionEngine {
	//Threshold values for different length of time
	static final long DAILY_THRESHOLD = 54000; //15 Hours
	static final double DAILY = 86400;
	static final long WEEKLY_THRESHOLD = 108000; //1 day 6 hours
	static final double WEEKLY = 604800;
	static final long BIWEEKLY_THRESHOLD = 259200; //2 days 12 hours
	static final double BIWEEKLY = 1209600;
	static final long MONTHLY_THRESHOLD = 432000; //5 days
	static final double MONTHLY = 2419200;
	static final long BIMONTHLY_THRESHOLD = 604800;	// 7 Days
	static final double BIMONTHLY = 4838400;
	
	//Given a string(payment text) and TransactionEvents, it returns a string describing how often this payment occurs
	String getRecurringTransactions(String key, TransactionEvents tEvents);
}