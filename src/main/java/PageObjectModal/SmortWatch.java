package PageObjectModal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmortWatch {
	WebDriver driver;
	
	public WebElement getCompareckbox() {
		return Compareckbox;
	}
	public WebElement getComparebtn() {
		return Comparebtn;
	}
	@FindBy(xpath = "//input[@aria-label=\"Compare\"]") private WebElement Compareckbox;
	@FindBy(xpath = "//button[@type=\"button\"]") private WebElement Comparebtn;
	public SmortWatch(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	} 

}
