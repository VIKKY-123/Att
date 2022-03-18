package PageObjectModal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	
	@FindBy(xpath ="//span[text()='Phones & devices']") private WebElement Phones_Devicestab;
	
	public WebElement getPhones_Devicestab() {
		return Phones_Devicestab;
	} 
	

	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	
	

}
