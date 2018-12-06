package com.techlab.connection;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class TestConnection {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1/swabhav", "root", "root");
			System.out.println(con);
			System.out.println(con.getClass());
			
			Statement state=(Statement) con.createStatement();
			ResultSet rs=state.executeQuery("select * from college");
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
