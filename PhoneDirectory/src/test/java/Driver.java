package test.java;

import main.java.PropertyReader;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PropertyReader filename = new PropertyReader();
		String name = filename.read();
		System.out.println(name);
	}

}
