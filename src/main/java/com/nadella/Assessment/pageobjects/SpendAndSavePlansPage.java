package main.java.com.nadella.Assessment.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpendAndSavePlansPage {

	WebDriver driver;
	public SpendAndSavePlansPage(WebDriver driver) {
		this.driver = driver;

		// This init will create all elements
		PageFactory.initElements(driver, this);
	}

	// Get Aspiration button from the plans
	@FindBy(xpath = "//div[@class='plan-content']//button[@ng-click='getAspirationOriginal()']")
	WebElement getAspirationBtn;

	// Get Aspiration Plus button from the plans
	@FindBy(xpath = "//div[@class='plan-content']//button[@ng-click='getAspirationPlus()']")
	WebElement getAspirationPlusBtn;
	
	public WebElement getAspiration()
	{
		return getAspirationBtn;
	}
	
	public WebElement getAspirationPlus()
	{
		return getAspirationPlusBtn;
	}

}
