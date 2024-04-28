package logger_using_log4j;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjectmodel_using_pagefactory.Page_Class_For_LoginPage_With_PageFactory;

//script for logging for login page using log4j
public class Log_For_LoginPage_Using_Log4J {

	public static void main(String[] args)   {

		Logger log = Logger.getLogger("OrangeHRM Project");
		PropertyConfigurator.configure("./log4j.properties");

		WebDriver driver = new ChromeDriver();
		log.info("Browser Opened");

		driver.manage().window().maximize();
		log.info("Browser Maximizied");

		driver.get("https://opensource-demo.orangehrmlive.com/");
		log.info("Launched OrangeHRM Site");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Page_Class_For_LoginPage_With_PageFactory login_page = new Page_Class_For_LoginPage_With_PageFactory(driver);

		login_page.username("Admin");
		
		log.info("Username entered");
		login_page.password("admin123");
	
		log.info("Password entered");
		login_page.login();
	
		log.info("Clicked Login");
		login_page.userid();

		log.info("Clicked UserID");
		login_page.logout();
		
		log.info("Clicked Logout");

		driver.quit();
	}

}
