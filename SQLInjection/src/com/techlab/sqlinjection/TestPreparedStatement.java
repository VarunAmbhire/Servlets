package com.techlab.sqlinjection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class TestPreparedStatement {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:4040/swabhav", "root", "root");

		Scanner scanner=new Scanner(System.in);
		String id=scanner.nextLine();
		
		PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from emp where empno=?");
		statement.setString(1, id);
		
		ResultSet resultSet=statement.executeQuery();
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
		}
		con.close();

	}

}
