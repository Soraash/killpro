package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileKill {

	public static void main(String[] args) {
		WindowsProcessKiller pKiller = new WindowsProcessKiller();
		try {
			Properties prop = new Properties();
			String projectPath = System.getProperty("user.dir");
			InputStream input = new FileInputStream(projectPath + "/src/config/Application.properties");
			prop.load(input);
			String[] str = prop.getProperty("foo").split(",");
			//String str=prop.getProperty("chromepath");
			System.out.println(str);
			boolean isRunning = pKiller.isProcessRunning(str);

			System.out.println("is " + str + " running : " + isRunning);

			if (isRunning) {
				pKiller.killProcess(str);
			}
			else {
				System.out.println("Not able to find the process : "+str);
			}


		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();

			e.printStackTrace();
		}
		
		

	}



}
