package com.techlabs.model;

public class Contacts {
	private String id;
	private String name;
	private String eMail;
	private String state;
	private String gender;
	
	public Contacts(String id, String name, String eMail, String state, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.eMail = eMail;
		this.state=state;
		this.gender=gender;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String geteMail() {
		return eMail;
	}
	
	public String getState() {
		return state;
	}
	
	public String getGender() {
		return gender;
	}
	
}
