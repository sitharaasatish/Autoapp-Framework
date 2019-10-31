package seleniumPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {
	public Properties configFile() {
		
		try {

			Properties configproperties = new Properties();
			FileInputStream fis = new FileInputStream("configTest.properties");
			configproperties.load(fis);
			return configproperties;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	public static void main(String[] args) {
		PropertiesClass p = new PropertiesClass();
		p.configFile();

	}

}
