package fileHandling;

import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFileWritter {
	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			
			prop.setProperty("URL", "https://letcode.in/test");
			prop.setProperty("User", "Ragulragavendra");
			
			String filepath=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
			
			FileOutputStream file = new FileOutputStream(filepath);
			
			prop.store(file, "App config details");
			
			file.close();
		}catch(Exception excep) {
			System.out.println("Unable to create and write the properties file");
			excep.printStackTrace();
			
		}
		
	}

}
