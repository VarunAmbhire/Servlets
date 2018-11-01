package com.techlabs.model;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	private static List<Contacts>contactList;
	
	 private static ContactService instance;
	    
	    private ContactService() {
			// TODO Auto-generated constructor stub
		}
	    
	    public static ContactService getInstance(){
	        if(instance == null){
	            instance = new ContactService();
	            contactList=new ArrayList<>();
	            
	            Contacts contacts=new Contacts("101", "Varun", "varun@gmail.com","MH", "male");
	    		Contacts contacts1=new Contacts("102", "Disp", "displ@gmail.com","GJ","female");
	    		Contacts contacts2=new Contacts("103", "Right", "right@gmail.com","GA","male");
	    		
	    		contactList.add(contacts);
	    		contactList.add(contacts1);
	    		contactList.add(contacts2);
	        }
	        return instance;
	    }
	
	public List<Contacts> getContactList(){		
		return contactList;
	}	
	
	public void addContact(Contacts cont) {
		contactList.add(cont);
	}
	
	public Contacts getById(String id) {		
		for(Contacts contacts : contactList)
		{
			if(contacts.getId().equals(id)) {
				return contacts;
			}
		}
		return null;
	}
	
	public void updateContact(Contacts contact) {
		int index=0;
		for(Contacts contacts : contactList)
		{
			if(contacts.getId().equals(contact.getId())) {
				contactList.set(index, contact);
			}
			index++;
		}
	}
	
	public void removeContact(String id) {
		int index=0;
		int i=0;
		for(Contacts contacts : contactList)
		{
			if(contacts.getId().equals(id)) {
				i=index;
			}
			index++;
		}

		contactList.remove(i);
	}
}
