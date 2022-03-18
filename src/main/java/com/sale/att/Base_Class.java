package com.sale.att;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {

	public WebDriver driver;
	public FileLib fil=new FileLib();
	public WebDriverUility webutil=new WebDriverUility();

	@BeforeSuite
	public void connection_DB() {
		System.out.println("===Connection_DataBase===");
	}
	@BeforeClass(groups= {"smoke","regretion"})
	public void Open_Browser( ) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		String BROWSER = fil.readpropertieData("browser");

		if(BROWSER.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		}

		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}

	}
	@BeforeMethod
	public void OpenAtt() throws IOException {
		FileLib filutil=new FileLib();
		driver.get(filutil.readpropertieData("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@AfterMethod
	public void signout() {
		System.out.println("close connection");
	}
	
	
	
	
	@AfterClass
	
	public void Close_Browser() throws InterruptedException {
		Thread.sleep(10000);
		
		driver.close();
		
		
	}
	@AfterSuite
	
	public void disconnectDBconnection() {
		
		Reporter.log("dis connect Data Base Connections");
	}
	
}
