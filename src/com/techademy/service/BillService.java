package com.techademy.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.techademy.dao.BillDao;
import com.techademy.entities.Bill;
import com.techademy.entities.Reading;

public class BillService {
	
	
	List<Bill>bills;
	
	public BillService()
	{
		bills=new ArrayList<Bill>();
	}
	
	
	public void readFromFile()
	{
		/*
		 * Insert code to get the meter readings from the file 'readings'
		 * and create 'Readings' object and then with the help of the method
		 * 'calculateBill() calculate the bill and obtain the 'Bill' object 
		 */
				// writeToDB(bills);

		 BufferedReader reader;
    try {
        reader = new BufferedReader(new FileReader("readings.txt"));
        String line = reader.readLine();
        while (line != null) {
            String[] data = line.split(",");
            long consumerNo = Long.parseLong(data[0]);
            double prevRead = Double.parseDouble(data[1]);
            double currRead = Double.parseDouble(data[2]);
            Reading reading = new Reading(consumerNo, prevRead, currRead);
            Bill bill = calculateBill(reading);
            bills.add(bill);
            line = reader.readLine();
        }
        reader.close();
        writeToDB(bills);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }	
			
			
		}
		
	
	
	public Bill calculateBill(Reading reading)
	{
		// Bill bill=new Bill();
		// /*
		//  * Insert code to get the 'reading' details, calculate the
		//  * bill details and initialize the 'Bill' object. 
		//  */
		// return bill;

		Bill bill = new Bill();
    bill.setConsumerNo(reading.getConsumerNo());
    bill.setPrevRead(reading.getPrevRead());
    bill.setCurrRead(reading.getCurrRead());

    double units = bill.getCurrRead() - bill.getPrevRead();

    // Calculate the bill amount based on the units consumed
    double billAmount = 0;
    if (units > 0 && units <= 100) {
        billAmount = units * 1.5;
    } else if (units > 100 && units <= 200) {
        billAmount = (100 * 1.5) + ((units - 100) * 2.5);
    } else if (units > 200 && units <= 300) {
        billAmount = (100 * 1.5) + (100 * 2.5) + ((units - 200) * 3.5);
    } else if (units > 300) {
        billAmount = (100 * 1.5) + (100 * 2.5) + (100 * 3.5) + ((units - 300) * 4.5);
    }
    bill.setBillAmount(billAmount);

    // Set the due date for the bill as 10 days from today's date
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    calendar.add(Calendar.DATE, 10);
    bill.setDueDate(calendar.getTime());

    return bill;
		
	}
	
	public void writeToDB(List<Bill> bills)
	{
		/*
		 * Insert code to get the bills details from the list
		 * and with the help of the dao object insert the details 
		 * into the table 'bills'
		 */

		BillDao dao = new BillDao();
    for (Bill bill : bills) {
        dao.insert(bill);
    }
		
	}

}
