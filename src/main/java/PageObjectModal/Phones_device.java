package PageObjectModal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Phones_device {
	WebDriver driver;
	@FindBy(xpath = "//a[@id=\"Categories-3\"]") private WebElement Smortwatchlnk;
	
	public WebElement getSmortwatchlnk() {
		return Smortwatchlnk;
	}

	public Phones_device(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	} 

}
