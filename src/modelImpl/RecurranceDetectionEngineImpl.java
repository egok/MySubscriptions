package modelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import dataTypes.TransactionEvents;
import model.RecurranceDetectionEngine;
import model.TransactionEvent;

public class RecurranceDetectionEngineImpl implements RecurranceDetectionEngine{

	// TODO: Change the design to make it static method??
	// TODO: Improved logic by writing a statistics backed logic to make it more dynamic
	@Override
	public String getRecurringTransactions(String key, TransactionEvents tEvents){
		ArrayList<Long> recurringWeeklyTList = getRecurringTransactions(tEvents).get(key);

		if(recurringWeeklyTList == null) return "None";

		Collections.sort(recurringWeeklyTList);
		long tmpDate = 0;
		int tmpCounter = 1;
		int strengthOfOccuranceBiWeekly = 0;
		int strengthOfOccuranceMonthly = 0;

		for(long date : recurringWeeklyTList){
			if(tmpCounter!=1){
				if(almostEqual(date - tmpDate, 1209600)){
					strengthOfOccuranceBiWeekly++;
				}
				if(almostEqual(date - tmpDate, 2419200)){
					strengthOfOccuranceMonthly++;
				}
				tmpDate = date;
			}
			else{tmpDate = date;tmpCounter++;}
		}

		if((strengthOfOccuranceMonthly  > strengthOfOccuranceBiWeekly) &&
				((strengthOfOccuranceBiWeekly != 0 || strengthOfOccuranceMonthly != 0))){
				return "Monthly";
			}
		else if((strengthOfOccuranceMonthly < strengthOfOccuranceBiWeekly) &&
				((strengthOfOccuranceBiWeekly != 0 || strengthOfOccuranceMonthly != 0))){
				return "BiWeekly";
			}

		return "None";
	}

	// TODO: Change the design to make it static method??
	@Override
	public HashMap<String, ArrayList<Long>> getRecurringTransactions(TransactionEvents tEvents) {
		HashMap<String, ArrayList<Long>> recurringTList = new HashMap<>();
		HashMap<String, ArrayList<Long>> nonRecurringTList = new HashMap<>();
		for(TransactionEvent tEvent : tEvents){
			String key = tEvent.getText();
			long date = tEvent.getDate();
			ArrayList<Long> dates;
			if(recurringTList.containsKey(key)){
				dates = recurringTList.get(key);
				dates.add(date);
				recurringTList.put(key, dates);
			}
			else if(nonRecurringTList.containsKey(key)){
				dates = nonRecurringTList.get(key);
				dates.add(date);
				// get the dates, add the new date -- from nonRecurringTList
				recurringTList.put(key, dates);
				// Add the key and the updated dates to recurringTList
				nonRecurringTList.remove(key);
				// remove that entry form nonRecurringTList
			}
			else{
				dates = new ArrayList<Long>();
				dates.add(date);
				nonRecurringTList.put(key, dates);
				// add the entry to nonRecurringTList
			}
		}
		return recurringTList;
	}

	private static boolean almostEqual(long value1, long value2){
		return Math.abs(value1-value2)<THRESHOLD;
	}
}
