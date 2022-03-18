package com.att;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sale.att.Base_Class;
import com.sale.att.FileLib;
import com.sale.att.IAutoConstants;
import com.sale.att.WebDriverUility;

import PageObjectModal.CompareActions;
import PageObjectModal.Customize_your_smartwatchPage;
import PageObjectModal.Homepage;
import PageObjectModal.Phones_device;
import PageObjectModal.SmortWatch;
@Test
public class Att extends Base_Class {

	public WebDriver driver;

	public void smarthwatches() throws Throwable {

		Homepage homepage=new Homepage(driver);
		Phones_device phone_device=new Phones_device(driver);
		SmortWatch smortwatch=new  SmortWatch(driver);
		CompareActions compareactions=new  CompareActions(driver);
		Customize_your_smartwatchPage customize=new Customize_your_smartwatchPage(driver);
		WebDriverUility webutil=new WebDriverUility();

		homepage.getPhones_Devicestab().click();
		phone_device.getSmortwatchlnk().click();	

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor)driver;	


		WebElement button1 = smortwatch.getCompareckbox();
		js.executeScript("arguments[0].click();", button1);

		Thread.sleep(2000);

		for (int i = 0; i <= 4; i++) {
			driver.findElement(By.xpath("//a[@id=\"product_card"+i+"\"]/ancestor::div[@class=\"flex\"]//input")).click();

		}
		WebElement button2 =smortwatch.getComparebtn();
		js.executeScript("arguments[0].click();", button2);

		webutil.TakeScreenshort(driver, "comapere1");

		compareactions.getProcessorlink().click();

		Thread.sleep(2000);
		WebElement location1 =compareactions.getShopnowbtn();

		js.executeScript("arguments[0].scrollIntoView();", location1 );
		Thread.sleep(3000);

		compareactions.getShopnowbtn().click();

		customize.getColorBtn().click();

		webutil.TakeScreenshort(driver, "Smartwatchdetatils");

		WebElement location = customize.getPrizevalue();


		js.executeScript("arguments[0].scrollIntoView();", location );

		webutil.TakeScreenshort(driver, "Smartwatchdetails_2");

		String priceOfProduct = customize.getPrizetext().getText();

		FileLib fileutil=new FileLib();
		fileutil.writeExcelData("sheet3", 1, 1, priceOfProduct);


		String rating = customize.getRatingtext().getText();
		System.out.println(rating);

		if(rating.contentEquals("4")) {
			driver.findElement(By.xpath("//*[local-name()='svg' and @style=\"height: 24px;\"]")).click();
		}





	}

}
