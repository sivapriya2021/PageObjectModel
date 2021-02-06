package com.AppProject;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.Selenium.AppUtilties.ScreenCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.AppObjects.AppObjects;
import com.Selenium.AppUtilties.BrowserFactory;
import com.Selenium.AppUtilties.ConfigReader;





public class AppLoginTest {
	public static WebDriver driver;
	public static BrowserFactory browser;
	public static ConfigReader config;
	public static AppObjects Apploginpage;
	//public static WebLinks weblinks;
	public static ScreenCapture capture;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static Logger logger = Logger.getLogger(AppLoginTest.class);
	
	
	@BeforeSuite
	public void AppSuite() {
		browser=new BrowserFactory();
		config=new ConfigReader();
		capture = new ScreenCapture();
		 extent = new ExtentReports("./extent/report.html", true);
		PropertyConfigurator.configure("./myreports/log4j.properties");
		
	}
	
	
@BeforeTest
public void launchBrowser() {
	
	
	 driver=BrowserFactory.getBrowser(config.getbrowsername(),config.getbrowserurl());
	 System.out.println("launching browser");
}
	
@Test(priority=1,description="Verify valid login")
public void verifyvalidlogin() throws Exception {
	
	Apploginpage=new AppObjects(driver);
	test = extent.startTest("login test");
	
	Apploginpage.getusername(config.getusername());
	System.out.println("Verify user name");
	Reporter.log("verify user name");
	test.log(LogStatus.INFO,"verify user name");
	logger.info("verify user name");
	capture.screencapture(driver,"username");
	
	String screenShotPath = capture.screencapture(driver,"verify user name");
     String screen1 = test.addScreenCapture(screenShotPath);
     test.log(LogStatus.INFO, "Snapshot below: "+screen1);
	
	
	
	Apploginpage.getpassword(config.getpassword());
	System.out.println("verify password");
	logger.info("verify password");
	capture.screencapture(driver,"password");
	test.log(LogStatus.INFO, "verify password");
	
	String screenShotPath2 = capture.screencapture(driver,"verify password");
    String screen2 = test.addScreenCapture(screenShotPath2);
    test.log(LogStatus.INFO, "Snapshot below: "+screen2);
	
	
	Apploginpage.clickloginbutton();
	System.out.println("verify button");
	logger.info("verify button");
	test.log(LogStatus.INFO, "verify button");
	capture.screencapture(driver,"button");
	
try {
		
		Apploginpage.clicksignout();
		System.out.println("Verify signout button");
		logger.info("verify sign out");
		capture.screencapture(driver,"username1");
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
	}finally
	{
		System.out.println("login pass");
		capture.screencapture(driver,"loginpass");
	}
	
	
	
}
	
@Test(priority=2,description="Verify invalid login")
public void verifyinvalidlogin() throws Exception {
	
	Apploginpage=new AppObjects(driver);
	
	Apploginpage.getusername(config.getinvalidusername());
	System.out.println("Verify user name");
	capture.screencapture(driver,"username1");
	
	Apploginpage.getpassword(config.getpassword());
	System.out.println("verify password");
	capture.screencapture(driver,"password2");
	
	Apploginpage.clickloginbutton();
	System.out.println("verify button");
	capture.screencapture(driver,"login");
	
	try {
		
		Apploginpage.clicksignout();
		System.out.println("Verify signout button");
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
	}finally
	{
		System.out.println("login fail");
		capture.screencapture(driver,"username");
	}
	
	
}


@Ignore
@Test(priority=3,description="Verify HomeLin")
public void verifyhomelink() {
	//weblinks=new WebLinks(driver);
	//weblinks.verifyhelplink();
	//System.out.println("verify home link");
	//logger.info("verify home link");
	//capture.screencapture(driver, "home link");
}





@AfterTest
public void closeBrowser() {
	
	extent.flush();
	
	browser.closebrowser();
	System.out.println("Closing browser");
	logger.info("closing browser");
}

	
}
