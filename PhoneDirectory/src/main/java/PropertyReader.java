package main.java;

import main.resources.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	InputStream input = null;
	Properties prop = new Properties();
	String directoryPath;
	public PropertyReader(){
		directoryPath = "";
	}
	public String read(){
		try{
			input = new FileInputStream("src/main/resources/phone.properties");
			prop.load(input);
			directoryPath = prop.getProperty("path");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return directoryPath;
	}
}
