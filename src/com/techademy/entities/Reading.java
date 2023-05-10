package com.techademy.entities;

public class Reading {
	private long consumerNo;
	private double prevRead;
	private double currRead;

	// Parameterized constructor for initializing the fields
public Reading(long consumerNo, double prevRead, double currRead) {
    this.consumerNo = consumerNo;
    this.prevRead = prevRead;
    this.currRead = currRead;
}

// Getters & Setters for the fields
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


}
