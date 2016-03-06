/** Directory class allows the user to access the Phone Directory.
 * Contains Methods that can Add Entry, Remove Entry, Change Entry, or Retrieve Entry
 * Class uses an ArrayList to hold a temporary directory that is maintained only during program execution*/

package main.java.edu.howard.sys363.phone;

import java.util.*;

public class Directory {
	ArrayList<ContactInfo> tempDirectory = new ArrayList<ContactInfo>();
	FileEdit file = new FileEdit();
	
	public Directory(){
		
	}
	
	/** Searches through current array list and returns the location of an ContactInfo object*/
	public int search(String name, ArrayList<ContactInfo> contacts){
		for (ContactInfo c : contacts){
			if(c.personName == name)
				System.out.println(contacts.indexOf(c));
				return contacts.indexOf(c);
		}
		return -1;
	}
	
	/** Reads Data from file and populates tempDirectory arrayList found in Directory*/
	public void inputCurrentDirectory(){
		file.read(tempDirectory);
	}
	
	/** Adds entry to tempDirectory and also updates file*/
	public void addEntry(String name, String number){
		ContactInfo newContact = new ContactInfo();
		newContact.personName = name;
		newContact.phoneNum = number;
		tempDirectory.add(newContact);
		file.update(tempDirectory);
	}
	
	/** Deletes entry in tempDirectory and calls update files function*/
	public void deleteEntry(String name){
		int found = search(name, tempDirectory);
		if (found == -1)
			System.out.println("That name is not in Address Book");
		else{
			tempDirectory.remove(found);
			System.out.println("Your phone directory has been updated!");
		}
		file.update(tempDirectory);
		
	}
	
	/** Returns String value that corresponds to the person's name*/
	public String getNumber(String name){
		String response;
		ContactInfo temp = new ContactInfo();
		int found = search(name, tempDirectory);
		if (found == -1)
			response = "Error! \nThat name is not in Address Book";
		else{
			temp = tempDirectory.get(found);
			response = temp.phoneNum;
		}
		return response;
	}
	
	/** Changes phone number of the specified person according to user*/
	public void changeEntry(String name, String number){
		ContactInfo temp = new ContactInfo();
		int found = search(name, tempDirectory);
		if (found == -1)
			System.out.println("That name is not in Address Book");
		else{
			temp = tempDirectory.get(found);
			temp.phoneNum = number;
			tempDirectory.set(found, temp);
			file.update(tempDirectory);
			System.out.println("Your phone directory has been updated! /n");
		}
	}

}
