package com.techademy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.techademy.entities.Bill;
import com.techademy.utilities.DBUtility;

public class BillDao {
	
	
	public void writeToDB(List<Bill> bills)
	{
		//Obtaining the database connection
		Connection con=DBUtility.getConnection();
		//Insert code for writing the bills details to the table
		//'bills' of the database 'billdb'. Script for creating
		 // the table and the  the database you will find in the
		//script file 'script.sql' under the src package of the skeleton

		try {
			
			String query = "INSERT INTO bills(consumer_no, prev_read, curr_read, units, tot_charge, bill_date, due_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			//Loop through the list of bills and add each bill's details to the batch
			for (Bill bill : bills) {
				pstmt.setInt(1, bill.getConsumerNo());
				pstmt.setDouble(2, bill.getPrevRead());
				pstmt.setDouble(3, bill.getCurrRead());
				pstmt.setDouble(4, bill.getUnits());
				pstmt.setDouble(5, bill.getTotCharge());
				
				//Format the date strings to SQL date format
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date billDate = sdf.parse(bill.getBillDate());
				java.sql.Date sqlBillDate = new java.sql.Date(billDate.getTime());
				pstmt.setDate(6, sqlBillDate);
				
				java.util.Date dueDate = sdf.parse(bill.getDueDate());
				java.sql.Date sqlDueDate = new java.sql.Date(dueDate.getTime());
				pstmt.setDate(7, sqlDueDate);
				
				pstmt.addBatch();
			}
			
			//Execute the batch of inserts
			pstmt.executeBatch();
			
			//Close the statement
			pstmt.close();
			
		} catch (Exception e) {
			//Handle any exceptions
			e.printStackTrace();
		} finally {
			//Close the connection
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
