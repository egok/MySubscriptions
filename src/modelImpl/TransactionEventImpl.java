package modelImpl;

import model.TransactionEvent;

public class TransactionEventImpl implements TransactionEvent{
	
	long myDateOfTransaction;
	String myTextDescription;
	String myEventType;
	double myAmount;
	String myRecepientNumber;

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
		// TODO convert it to normal date?
		return myDateOfTransaction;
	}
	
	@Override
	public Double getAmount() {
		return myAmount;
	}
	
	// Builder Class
	public static class TransactionEventBuilder{
		private long myDateOfTransaction;
		private String myTextDescription;
		private String myEventType;
		private double myAmount;
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
