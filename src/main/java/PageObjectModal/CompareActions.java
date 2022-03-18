package PageObjectModal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompareActions {
	WebDriver driver;
	public WebElement getProcessorlink() {
		return processorlink;
	}

	public WebElement getShopnowbtn() {
		return Shopnowbtn;
	}

	@FindBy(xpath = "//div[@id=\"deviceLabel4\"]/.") private WebElement processorlink;
	@FindBy(xpath = "//div[@id=\\\"deviceCta2\\\"]") private WebElement Shopnowbtn;
	
	public CompareActions(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	} 

}
