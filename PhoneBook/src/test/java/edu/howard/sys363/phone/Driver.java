/** Tests the Phone Directory System using Directory.java methods
 * Requires User Input
 * Allows User the option to use a saved directory or not
 * Directory stored in file has first name and last name followed by phone number on separate line*/

package test.java.edu.howard.sys363.phone;

import java.util.*;
import main.java.edu.howard.sys363.phone.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int userinput;
		String yesNO;
		String name;
		String number;
		Directory directoryCommand = new Directory();
		Scanner stdin = new Scanner(System.in);
		System.out.println("Welcome to your Phone Directory\n");
		System.out.println("\nWould you like to import current contacts? (Y/N)");
		yesNO = stdin.next();
		if (yesNO.equals("Y")){
			directoryCommand.inputCurrentDirectory();	
		}
		System.out.println("What would you like to do?");
		System.out.println("Select Number:");
		System.out.println("1 - Add Contact | 2 - Delete Contact | 3 - Change Number | 4 - Retrieve Number | 0 - Exit");
		userinput = stdin.nextInt();
		while (userinput != 0){
			if (userinput == 1){
				System.out.println("\nEnter full name you would like to add: ");
				name = stdin.next() + " " + stdin.next();
				System.out.println("\nEnter phone number: ");
				number = stdin.next();
				directoryCommand.addEntry(name,number);
				System.out.println("\nYour phone directory has been updated!");
			}
			else if (userinput == 2){
				System.out.println("\nEnter full name you would like to delete: ");
				name = stdin.next() + stdin.next();
				directoryCommand.deleteEntry(name);
			}
			else if (userinput == 3){
				System.out.println("\nEnter full name you would like to change: ");
				name = stdin.next() + stdin.next();
				System.out.println("\nEnter new phone number: ");
				number = stdin.next();
				directoryCommand.changeEntry(name, number);
			}
			else if (userinput == 4){
				System.out.println("\nEnter full name of person whose number you would like to retrieve: ");
				name = stdin.next() + stdin.next();
				number = directoryCommand.getNumber(name);
				System.out.println("Her/His number is: " + number);
			}
			else
				System.out.println("Invalid input, try again");
			System.out.println("\n\nWhat would you like to do next?");
			System.out.println("Select Number:");
			System.out.println("1 - Add Contact | 2 - Delete Contact | 3 - Change Number | 4 - Retrieve Number | 0 - Exit");
			userinput = stdin.nextInt();
		}
		stdin.close();
		System.out.println("You have exited the phone directory. Goodbye!");
	}

}
