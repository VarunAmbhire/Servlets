package com.techlabs.model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DataBaseService {
	List<Contacts>list=new ArrayList<>();
	Connection con;
	 
	public DataBaseService() throws Exception {
		 Class.forName("com.mysql.jdbc.Driver");
		 con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:4040/swabhav", "root", "root");
	 }
	
	public List<Contacts> getList() throws Exception{
		PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from Contact");
		ResultSet resultSet=statement.executeQuery();
		while(resultSet.next()) {
			list.add(resultSet);
		}
		
		return list;
	}

	public void insertData(String id, String name, String email, String state, String gender) throws Exception {
		PreparedStatement statement=(PreparedStatement) con.prepareStatement("insert into Contact values(?,?,?,?,?)");
		statement.setString(1, id);
		statement.setString(2, name);
		statement.setString(3, email);
		statement.setString(4, state);
		statement.setString(5, gender);
		
		statement.execute();
	}
	

}
