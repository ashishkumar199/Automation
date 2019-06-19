package com.TL.Utils;

import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;		


public class  SQLConnector {	
	
	public String ExecuteQuery (String SQLstatement, String clomunName) throws SQLException, ClassNotFoundException { 
	   	
		 //Load MS SQL JDBC Driver
		 Class.forName("net.sourceforge.jtds.jdbc.Driver");
	
		 //Creating connection to the database
		 Connection con = DriverManager.getConnection(PropertyReader.readDataProperty("dbURL"),
				 PropertyReader.readDataProperty("dbUsername"),PropertyReader.readDataProperty("dbPassword"));
		 if (con != null) {
             System.out.println("Connected to the Database...");
         }
		 
		 Statement st = con.createStatement();
		 
		 //String selectquery = "SELECT * FROM Miicrras..associate_master where AM_Status = 'A'";
		 //Executing the SQL Query and store the results in ResultSet
		 
		 ResultSet rs = st.executeQuery(SQLstatement);
		 //While loop to iterate through all data and print results
		 
		 while (rs.next()) {
		  System.out.println(rs.getString(clomunName));
		  String value = rs.getString(clomunName);
		  return value;
		 }
		 //Closing DB Connection
		
		 con.close();
		return clomunName;
	}
	/*
	public void OperationalMethod() {
		try {
			// Execute a query
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery("select * from sampletable");

			// Get the all row of UI Table
			List<WebElement> lstTr = driver.findElement(By.id("grdData")).findElements(By.tagName("tr"));

			// Index for Row
			int rowCount = 0;

			// Count of Matched Column
			int matchColumnCount = 0;

			// Count of Matched Row
			int matchRowCount = 0;

			System.out.println("Row Count => " + lstTr.size());

			// Extract the data from Table
			while (resultSet.next()) {

			
			//(rowCount + 1) because first row is a header row , Get all the columns from a particular row
			List<WebElement> lstTd = lstTr.get(rowCount + 1).findElements(By.tagName("td"));
			System.out.println("Cloumn Count => " + lstTd.size());

			for (int j = 0; j < lstTd.size(); j++) {
				String uiCell = lstTd.get(j).getText();
				System.out.println("UI Cell Data => " + uiCell);

				/*
				* (j + 1) in the resultSet => because index is start from 1
				* and here loop is starting from 0
				*/
	/*      	String dbCell = resultSet.getString(j + 1);
				System.out.println("DB Cell Data => " + dbCell);

				// Comparison between both string
				if (uiCell.trim().equalsIgnoreCase(dbCell.trim())) {
					matchColumnCount++;
				}
			}
				
			if (matchColumnCount == lstTd.size()) {
				matchRowCount++;
				System.out.println("========ROW MATCHED==========");
			}

			// Set 'matchColumnCount' to 0 for next row	matchColumnCount = 0;
				rowCount++;
			}
				assertEquals(matchRowCount, rowCount, "UI Table is the exact copy of Database Table");
		} catch (Exception e) {
				System.out.println(e);
		}
	}
	
	/*
	/*
	   public void SelectQueryExecutor (String SQLstatement)  { 
		 //Creating statement object
			 Statement st = sqlConnection.createStatement();
			 
			 //String selectquery = "SELECT * FROM Miicrras..associate_master where AM_Status = 'A'";
			 //Executing the SQL Query and store the results in ResultSet
			 
			 ResultSet rs = st.executeQuery(SQLstatement);
			 //While loop to iterate through all data and print results
			 
			 while (rs.next()) {
			 System.out.println(rs.getString("AM_id"));
			 System.out.println(rs.getString("AM_client_Id"));
			 }
			 //Closing DB Connection
			 sqlConnection.close();
	   }		   
	   	*/
	
}