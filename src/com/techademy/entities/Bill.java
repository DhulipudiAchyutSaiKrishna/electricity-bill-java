package com.techademy.entities;

import java.util.Date;

public class Bill {
	
	private long consumerNo;
	private double prevRead;
	private double currRead;
	private double units;
	private double totCharge;
	private Date billDate;
	private Date dueDate;
	
	
	//Define a no argument constructor function  for the class
	public Bill() {
		
	}

	//Define getters & setters for the fields

	public long getConsumerNo() {
		return consumerNo;
	}


	public void setConsumerNo(long consumerNo) {
		this.consumerNo = consumerNo;
	}


	public double getPrevRead() {
		return prevRead;
	}


	public void setPrevRead(double prevRead) {
		this.prevRead = prevRead;
	}


	public double getCurrRead() {
		return currRead;
	}


	public void setCurrRead(double currRead) {
		this.currRead = currRead;
	}


	public double getUnits() {
		return units;
	}


	public void setUnits(double units) {
		this.units = units;
	}


	public double getTotCharge() {
		return totCharge;
	}


	public void setTotCharge(double totCharge) {
		this.totCharge = totCharge;
	}


	public Date getBillDate() {
		return billDate;
	}


	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	
	

}
