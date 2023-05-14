package model;

import java.util.Calendar;

public class Transaction {

	private Calendar date;
	private double purchaseValue;
	private String bookName;


	public Transaction(Calendar date, double purchaseValue, String bookName) {

		this.date = date;
		this.purchaseValue = purchaseValue;
		this.bookName = bookName;
	
		
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(double purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	

	

}
