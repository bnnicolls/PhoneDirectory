/** FileEdit class uses file obtained from PropertyReader
 * Allows for Directory Program to make changes to the file found in phone.properties*/

package main.java.edu.howard.sys363.phone;

import java.io.*;
import java.util.*;

public class FileEdit {
	String path;
	PropertyReader filename = new PropertyReader();
	FileEdit(){
		path = filename.read();
	}
	File f = new File(filename.read());
	
	/** Reads Data from file and populates tempDirectory arrayList found in Directory class*/
	public void read(ArrayList<ContactInfo> array){
		Scanner scnr;
		String name="";
		String number="";
		ContactInfo temp = new ContactInfo();
		try {
			scnr = new Scanner(f);
			while (scnr.hasNextLine()){
				name = scnr.nextLine();
				number = scnr.nextLine();
				temp.personName = name;
				temp.phoneNum = number;
				array.add(temp);
			}
			scnr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** Deletes and Creates a New File with updated tempDirectory arrayList used in Directory class*/
	public void update(ArrayList<ContactInfo> array){
		f.delete();
		try{
			f.createNewFile();
			FileWriter fstream = new FileWriter(filename.read());
			BufferedWriter out = new BufferedWriter(fstream);
			for (ContactInfo c : array){
				out.write(c.personName);
				out.newLine();
				out.write(c.phoneNum);
				out.newLine();
			}
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
