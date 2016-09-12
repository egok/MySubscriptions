package dataTypesImpl;

import java.util.Objects;

import dataTypes.TransactionEvent;

public class TransactionEventImpl implements TransactionEvent, Comparable<TransactionEvent>{
	
	private long myDateOfTransaction;
	private String myTextDescription;
	private String myEventType;
	private double myAmount;
	private String myRecepientNumber;

	public TransactionEventImpl(TransactionEventBuilder builder) {
		this.myDateOfTransaction = builder.myDateOfTransaction;
		this.myTextDescription = builder.myTextDescription;
		this.myEventType = builder.myEventType;
		this.myAmount = builder.myAmount;
		this.myRecepientNumber = builder.myRecepientNumber;
	}
	
	public static TransactionEventBuilder teventBuilder(){
		return new TransactionEventBuilder();
	}
	
	@Override
	public String getText() {
		return myTextDescription;
	}
	
	@Override
	public String getEventType() {
		return myEventType;
	}
	
	@Override
	public long getDate() {
		return myDateOfTransaction;
	}
	
	@Override
	public Double getAmount() {
		return myAmount;
	}
	
	@Override
	public String getRecepientNumber() {
		return myRecepientNumber;
	}
	
	@Override
	public int compareTo(TransactionEvent o) {
		int result = myTextDescription.compareTo(o.getText());

		result = result == 0 ? Double.compare(myAmount, o.getAmount()) : result;
        result = result == 0 ? Long.compare(myDateOfTransaction, o.getDate()) : result;
        result = result == 0 ? myEventType.compareTo(o.getEventType()) : result;
        result = result == 0 ? myRecepientNumber.compareTo(o.getRecepientNumber()) : result;
        return result;
		//return myTextDescription.compareTo(o.getText());
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(myAmount,
				myDateOfTransaction, 
				myEventType, 
				myRecepientNumber, 
				myTextDescription);
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
		{
			return true;
		}
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        TransactionEventImpl other = (TransactionEventImpl) obj;
        
        return Objects.equals(myAmount, other.myAmount)&&
        Objects.equals(myDateOfTransaction, other.myDateOfTransaction)&&
		Objects.equals(myEventType, other.myEventType)&&
		Objects.equals(myRecepientNumber, other.myRecepientNumber)&&
		Objects.equals(myTextDescription, other.myTextDescription);
	}
	
	// Builder Class
	public static class TransactionEventBuilder{
		private long myDateOfTransaction = 0;
		private String myTextDescription = "";
		private String myEventType = "";
		private double myAmount = 0;
		public String myRecepientNumber = "";
		
		// To restrict access from out side the class
		private TransactionEventBuilder() {}
		
		public TransactionEvent build(){
			return new TransactionEventImpl(this);
		}
		
		public TransactionEventBuilder dateOfTransaction(long dateOfTransaction){
			myDateOfTransaction = dateOfTransaction;
			return this;
		}
		
		public TransactionEventBuilder textDescription(String textDescription){
			myTextDescription = textDescription;
			return this;
		}
		public TransactionEventBuilder eventType(String eventType){
			myEventType = eventType;
			return this;
		}
		public TransactionEventBuilder amount(double amount){
			myAmount = amount;
			return this;
		}
		public TransactionEventBuilder recepientNumber(String recepientNumber) {
			myRecepientNumber = recepientNumber;
			return this;
		}
	}
}
