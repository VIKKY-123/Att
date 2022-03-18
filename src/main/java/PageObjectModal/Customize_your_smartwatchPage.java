package PageObjectModal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customize_your_smartwatchPage {
	WebDriver driver;
	public WebElement getColorBtn() {
		return colorBtn;
	}

	public WebElement getPrizevalue() {
		return prizevalue;
	}

	public WebElement getPrizetext() {
		return prizetext;
	}

	public WebElement getRatingtext() {
		return ratingtext;
	}

	public WebElement getFavoritesimg() {
		return favoritesimg;
	}

	@FindBy(xpath = "//input[@id=\"StarlightAluminumPlatinumBlackSport\"]") private WebElement colorBtn;
	@FindBy(xpath = "//h2[text()='Pricing option']") private WebElement prizevalue;
	@FindBy(xpath = "//span[text()='$529.99']") private WebElement prizetext;
	@FindBy(xpath = "//div[text()='4.7']") private WebElement ratingtext;
	@FindBy(xpath = "//*[local-name()='svg' and @style=\"height: 24px;\"]") private WebElement favoritesimg;
	
	public Customize_your_smartwatchPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	} 

}
