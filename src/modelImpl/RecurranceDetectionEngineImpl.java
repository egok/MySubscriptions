package modelImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import dataTypes.TransactionEvents;
import model.RecurranceDetectionEngine;
import dataTypes.TransactionEvent;

public class RecurranceDetectionEngineImpl implements RecurranceDetectionEngine{

	// TODO: Change the design to make it static method??
	@Override
	public String getRecurringTransactions(String key, TransactionEvents tEvents) {
		boolean hitOccurance = false; // When an element with name same as "key" is found this will be changed to "true"
		ArrayList<Double> recurringAmount = new ArrayList<>();
		ArrayList<Long> recurringDates = new ArrayList<>(); //Dates will be ordered. Look at the implementation of method compareto/1 in TransactionEvent
		for(TransactionEvent tEvent : tEvents)
		{
			//getting first occurance of "Key" and then adding subsequent dates to recurringDates
			if(tEvent.getText().equals(key))
			{
				if(!hitOccurance) // goes here on the first hit of "key" match
				{
					hitOccurance = true;
				}
				recurringAmount.add(tEvent.getAmount());
				recurringDates.add(tEvent.getDate());
			}
			else if(hitOccurance)
			{
				break;
			}
		}
		return checkOccurance(recurringDates, recurringAmount);
	}
	
	//Calculates the difference between subsequentDates(sorted array list with long)
	//If the amounts differ, then it only takes in account the most repeated amount
	private String checkOccurance(ArrayList<Long> recurringDates, ArrayList<Double> recurringAmount) {
		HashMap<Double, Integer> counterMap = getAmountAndNoOfOccurences(recurringAmount);
		double highestoccuringAmount = getHighestOccuringAmount(counterMap);
		long sum = 0;
		int count = 0;
		long dateBeforeOtherAmount = 0;
		for(int i = 0; i < recurringDates.size()-1; i++){
			if((recurringAmount.get(i) == highestoccuringAmount) && 
					(recurringAmount.get(i+1) == highestoccuringAmount)){
					sum += recurringDates.get(i+1) - recurringDates.get(i);
					count++;
			}
			else if((recurringAmount.get(i) != highestoccuringAmount) &&
					(recurringAmount.get(i+1) == highestoccuringAmount)) {
				sum += recurringDates.get(i+1) - dateBeforeOtherAmount;
				count++;
			}
			else if(recurringAmount.get(i+1) != highestoccuringAmount){
				dateBeforeOtherAmount = recurringDates.get(i);
			}			
		}
		return checkOccurance(sum, count);
	}
	
	// param: counterMap. The map returned from method getAmountAndNoOfOccurences/1
	// It returns PaymentAmount(key) which has highest value
	private double getHighestOccuringAmount(HashMap<Double, Integer> counterMap) {
		Double highestValue = null;
		for(Map.Entry<Double, Integer> entry: counterMap.entrySet()){
			if(highestValue == null || entry.getValue().compareTo(counterMap.get(highestValue)) > 0){
				highestValue = entry.getKey();
				}
			}
		return highestValue;
	}
	
	// Returns a Map<Double, Integer>
	// The Double is the key, with amount 
	// The integer is the value, with no. of times this amount repeated in the list
	private HashMap<Double, Integer> getAmountAndNoOfOccurences(ArrayList<Double> recurringAmount){
		HashMap<Double, Integer> counterMap = new HashMap<>();
		for(int i = 0; i< recurringAmount.size(); i++){
			double amount = recurringAmount.get(i);
			Integer count = counterMap.get(amount);
			if(count!=null){
				counterMap.put(amount, count+1);
			}
			else{
				counterMap.put(amount, 1);
			}
		}
		return counterMap;
	}

	// Checks if either of the sum or total no of event are 0
	// If not check occurance with the average of sumOfIntervals
	private String checkOccurance(long sumOfTimeBetweenPayments, int noOfTEvents) {
		if(sumOfTimeBetweenPayments == 0 || noOfTEvents == 0){
				return "None";
			}
		else {
				return checkOccurance(sumOfTimeBetweenPayments/noOfTEvents);
			}
	}

	// Given no.of seconds between payments, this method returns human readable payment interval.
	// Threshold is the value which specifies, wheather averageDaysBetweenPayments amounts to a day/week/biweekly 
	//		if the threshold value is added or subtracted from the "averageDaysBetweenPayments"
	private String checkOccurance(double averageTimeBetweenPayments) {
		if (almostEqual(averageTimeBetweenPayments, DAILY, DAILY_THRESHOLD)) return "Daily";
		else if (almostEqual(averageTimeBetweenPayments, WEEKLY, WEEKLY_THRESHOLD)) return "Week";
		else if (almostEqual(averageTimeBetweenPayments, BIWEEKLY, BIWEEKLY_THRESHOLD)) return "BiWeekly";
		else if (almostEqual(averageTimeBetweenPayments, MONTHLY, MONTHLY_THRESHOLD)) return "Monthly";
		else if (almostEqual(averageTimeBetweenPayments, BIMONTHLY, BIMONTHLY_THRESHOLD)) return "Monthly";
		return "None";
	}
	
	// Checks if value1 and value2 are nearly equal
	private boolean almostEqual(double value1, double value2, long threshold){
		return Math.abs(value1-value2)<threshold;
	}
}
