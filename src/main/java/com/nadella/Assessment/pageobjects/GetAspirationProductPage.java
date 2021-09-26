package main.java.com.nadella.Assessment.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetAspirationProductPage {
	WebDriver driver;

	public GetAspirationProductPage(WebDriver driver) {
		this.driver = driver;

		// This init will create all elements
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#join-waitlist-input")
	WebElement email;
	
	@FindBy(css=".close")
	WebElement closeBtn;

	public WebElement email() {

		return email;

	}

	public void switchToAlert()
	{
		Set<String> s=driver.getWindowHandles();
		Iterator<String> it= s.iterator();
		while(it.hasNext())
		{
			String childWindow = it.next();
			driver.switchTo().window(childWindow);
		}
		
	}
	public WebElement closeAlert()
	{
		return closeBtn;
	}
}
