package com.crm.genericUtility;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;



public class DatabaseUtility {
	Connection con;
	/**
	 * This Method is used to connect Databse
	 * @author Darshil
	 * @throws SQLException
	 */
	public void connectDBcon() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
//		con = DriverManager.getConnection(IpathConstants.dbURL, IpathConstants.username, IpathConstants.password);
		con = DriverManager.getConnection(IpathConstants.bdUrl, IpathConstants.dbUserName, IpathConstants.dbPassword);
	}
	
	/**
	 * This Method is used to Execute 
	 * @author Darshil
	 * @param query
	 * @param Expdata
	 * @param columnNum
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query, String Expdata, int columnNum) throws SQLException {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {
			String data =result.getString(columnNum);
			if(data.equalsIgnoreCase(Expdata)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("Data is Verified");
			return Expdata;
		}else {
			System.out.println("Data is not Verified");
			return Expdata;
		}
	}
	
	/**
	 * This Method is used to Close the Connection
	 * @author Darshil
	 * @throws SQLException
	 */
	public void closeDbConnection() throws SQLException {
		con.close();
	}
}
