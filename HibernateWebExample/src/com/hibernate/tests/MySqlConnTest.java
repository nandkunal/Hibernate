package com.hibernate.tests;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlConnTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("-------- MySQL JDBC Connection Testing ------------");
	 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
	 
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
		 
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/jiac","root", "root");
			String sql="select * from t_users";
			java.sql.Statement stmt=connection.createStatement();
			ResultSet rset=stmt.executeQuery(sql);
			if(rset!=null){
				while(rset.next()){
					System.out.println("Value--"+rset.getString(3));
				}
			}
			
			
			
			
	 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
		
	}

}
