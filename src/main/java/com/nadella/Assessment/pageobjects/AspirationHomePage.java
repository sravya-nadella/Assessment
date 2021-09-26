package main.java.com.nadella.Assessment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AspirationHomePage {

	
	WebDriver driver;
	
	@FindBy(xpath = "//header[@data-id='header']//a[contains(text(),'Spend & Save')]")
	WebElement spendSave;
	
	//creating constructor to initialize the driver
	public AspirationHomePage(WebDriver driver)
	{
		this.driver = driver;
		
		//This init will create all elements
		PageFactory.initElements(driver, this);
	}
	
	//create method to click the link
	public WebElement clickSpendSave() {
	return spendSave;
	 } 

}

