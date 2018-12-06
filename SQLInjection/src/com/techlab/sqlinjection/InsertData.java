package com.techlab.sqlinjection;

import java.sql.DriverManager;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class InsertData {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:4040/swabhav", "root", "root");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID");
		String id=sc.nextLine();

		System.out.println("Enter Name");
		String name=sc.nextLine();
		
		PreparedStatement statement=(PreparedStatement) con.prepareStatement("insert into JDBCPract values(?,?)");
		statement.setString(1, id);
		statement.setString(2, name);
			
		statement.execute();

	}

}
