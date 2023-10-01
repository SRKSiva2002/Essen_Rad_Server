package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonSelectQueryDeleteTest {

	public static void main(String[] args) throws Throwable {
		
		Connection con=null;
		Driver driver= new Driver();
		
		DriverManager.registerDriver(driver);
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");
		Statement state=con.createStatement();
		String query="DELETE from project where subject='Project';";
		int res = state.executeUpdate(query);
		if (res>0) {
			System.out.println("Details are added");
		}
		else {
			System.out.println("Details are not added");
		}
		System.out.println();
		System.out.println("After adding details");
		String query1="select * from project";
		ResultSet res1 = state.executeQuery(query1);
		
		while (res1.next()) {
			System.out.println(res1.getString(1)+" "+res1.getString(2)+" "+res1.getString(3)+" "+res1.getString(4));
	}
		con.close();
	}
}
