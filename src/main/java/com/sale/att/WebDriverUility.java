package com.sale.att;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


/**
 * 
 * This class is Write the WebDriver methods 
 * @author DELL
 *
 */
public class WebDriverUility {
	/**
	 * 
	 * This Method is wait untill webpage loaded
	 * 
	 * @param driver
	 */

	public void pageloadedwait(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	/**
	 * this method is handling drop down
	 * @param element
	 * @param text
	 */

	public void selectfromDD( WebElement element, String text) {

		Select select=new Select(element);
		select.selectByVisibleText(text);

	}

	public void selectfromDD(String value, WebElement element ) {

		Select select=new Select(element);
		select.selectByValue(value);

	}
	public void selectfromDD( WebElement element, int index) {

		Select select=new Select(element);
		select.selectByIndex(index);

	}
	/**
	 * 
	 * @param driver
	 * @param title
	 */

	public void handlingWindows(WebDriver driver, String title) {

		Set<String> allwin = driver.getWindowHandles();

		for(String singlewin:allwin) {
			String correcttitle = driver.switchTo().window(singlewin).getTitle();
			if(correcttitle.contains(title)) {
				break;

			}


		}



	}
	/**
	 * This method is handling to mousehover
	 * @param driver
	 * @param element
	 */

	public void movetoElement(WebDriver driver, WebElement element) {

		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	/**
	 * this method is handling to the frames on webpage
	 * @param driver
	 * @param index
	 */


	public void switchtoframe(WebDriver driver, int index) {
		driver.switchTo().frame(index);	
	}


	public void switchtoframe(WebDriver driver, String value) {
		driver.switchTo().frame(value);
	}


	public void switchtoframe(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);	
	}

	/**
	 *  this method is used to handle for accepting the alert pop up
	 * @param driver
	 */
	public void alertaccept(WebDriver driver) {

		driver.switchTo().alert().accept();


	}
	/**
	 * this method is used to handle for dismissing the alert pop up
	 * @param driver
	 */

	public void alertdismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this method is used to the get the text from the alert pop up
	 * @param driver
	 * @return 
	 */
	public String getalertText(WebDriver driver) {
		return driver.switchTo().alert().getText();


	}

	public void TakeScreenshort(WebDriver driver, String name) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"/Screenshorts/"+name+".png";
		File file=new File(dest);
		FileUtils.copyFile(src, file);

	}



}
