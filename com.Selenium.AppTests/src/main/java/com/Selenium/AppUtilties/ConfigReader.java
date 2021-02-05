package com.Selenium.AppUtilties;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	
public static Properties prop;
	
	public ConfigReader() {
				
		try {
			File src = new File("./AppFiles/AppProperties.properties");
            FileInputStream fis = new  FileInputStream(src);
             prop = new Properties();
            prop.load(fis);
          //  System.out.println("Property class loaded");
        			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	
	
	//Methods created for properties
	public String getbrowsername() {
		return prop.getProperty("browsername");
	}
	
	public String getbrowserurl() {
		return prop.getProperty("browserurl");
	}
	
	public String getusername() {
		return prop.getProperty("username");
	}
	
	
	public String getinvalidusername() {
		return prop.getProperty("username1");
	}
	
	public String getpassword() {
		return prop.getProperty("password");
	}
	
	
	public String signoutelement() {
		return prop.getProperty("signout");
	}
	
	
	//Methods created for Repositories
	public String getunelement() {
		return prop.getProperty("appun");
	}
	
	public String getpwelement() {
		return prop.getProperty("apppw");
	}
	
	public String getbuttonelement() {
		return prop.getProperty("appbutton");
	}
	
	
	public String getHomeLinkelement() {
		return prop.getProperty("helplink");
	}
	
	

}
