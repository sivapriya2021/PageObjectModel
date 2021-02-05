package com.Selenium.AppUtilties;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenCapture {

			
			public static WebDriver driver;
			
			
			public  String screencapture(WebDriver driver,String screenname) throws IOException {
				
				
				TakesScreenshot element = (TakesScreenshot)driver;
				File scrFile = element.getScreenshotAs(OutputType.FILE);
				String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				File Dest = new File("./screens/" + screenname+dateName+ ".png");
				String errflpath = Dest.getAbsolutePath();
				FileUtils.copyFile(scrFile, Dest);
				return errflpath;
				
			
		
		
		
		
		
		
			}
		
		
		
		
		
	}
	
	

