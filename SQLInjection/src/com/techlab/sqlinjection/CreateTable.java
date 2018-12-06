package com.techlab.sqlinjection;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class CreateTable {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:4040/swabhav", "root", "root");
		
		PreparedStatement statement=(PreparedStatement) con.prepareStatement("create table JDBCPract(id int primary key, name varchar(255))");
			
		statement.execute();

	}

}
