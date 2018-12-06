package com.techlab.sqlinjection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestEmployee {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:4040/swabhav", "root", "root");

		Statement statement=(Statement) con.createStatement();
		
		Scanner scanner=new Scanner(System.in);
		String id=scanner.nextLine();
		
		ResultSet resultSet=statement.executeQuery("select * from emp where empno="+id);
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
		}
		con.close();
	}

}
