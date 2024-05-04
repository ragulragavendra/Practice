package fileHandling;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileReader {
	public static Properties prop;
	public static void LoadPropertyFile() {
		try {
			prop = new Properties();
			String filePath= System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
			
			FileInputStream file = new FileInputStream(filePath);
			
			prop.load(file);
			file.close();
			
		}catch(Exception excep) {
			System.out.println("Unable to read the properties file");
			excep.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		LoadPropertyFile();
		String User=prop.getProperty("User");
		System.out.println(User);
	}

}
