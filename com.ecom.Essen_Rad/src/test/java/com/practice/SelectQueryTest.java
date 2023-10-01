package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {

	public static void main(String[] args) throws Throwable {
		
		Connection con=null;
		try {
			//1. Register the database
			Driver driver = new Driver();
			
			DriverManager.registerDriver(driver);
			
			//2.get connection for database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");
			
			//3.create statement
			Statement state=con.createStatement();
			String query="select * from project";
			
			//4. execute query
			ResultSet res = state.executeQuery(query);
			
			while (res.next()) {
				System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
			}
			
		} catch (Exception e) {
		}
		finally {
			con.close();
		}
	}
}
