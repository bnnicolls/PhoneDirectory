/** Simply obtains path from phone.properties*/

package main.java.edu.howard.sys363.phone;

//import main.resources.*;
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
	
	/** Finds property "path" in phone.properties and stores value*/
	public String read(){
		try{
			input = new FileInputStream("src/main/resources/edu/howard/sys363/phone/phone.properties");
			prop.load(input);
			directoryPath = prop.getProperty("path");
		} catch(IOException ex) {
			ex.printStackTrace();
		}
		return directoryPath;
	}
}
