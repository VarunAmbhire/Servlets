package com.techlab.sqlinjection;

import java.sql.DriverManager;
import java.util.Scanner;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DeleteData {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:4040/swabhav", "root", "root");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter ID");
		String id=sc.nextLine();

		PreparedStatement statement=(PreparedStatement) con.prepareStatement("delete from JDBCPract where id=?");
		statement.setString(1, id);
			
		statement.execute();


	}

}
