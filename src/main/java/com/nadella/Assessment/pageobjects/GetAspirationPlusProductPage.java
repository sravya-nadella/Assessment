package main.java.com.nadella.Assessment.pageobjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetAspirationPlusProductPage {
	WebDriver driver;

	public GetAspirationPlusProductPage(WebDriver driver) {
		this.driver = driver;

		// This init will create all elements
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='options']/div[1]")
	WebElement yearlyRadioBtn;

	@FindBy(xpath = "//div[@class='options']/div[2]")
	WebElement monthlyRadioBtn;

	@FindBy(xpath = "//div[@class='options']/div[1]/p")
	WebElement yearlyRadioBtnText;

	@FindBy(xpath = "//div[@class='options']/div[2]/p")
	WebElement monthlyRadioBtnText;

	public void switchToAlert() {
		Set<String> s = driver.getWindowHandles();
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			String childWindow = it.next();
			driver.switchTo().window(childWindow);
		}

	}

	public WebElement verifyYearlyRadioBtns() {
		return yearlyRadioBtn;

	}

	public WebElement verifyMonthlyRadioBtns() {
		return monthlyRadioBtn;

	}

	public String verifyYearlyRadioBtnText() {
		return yearlyRadioBtnText.getText();

	}

	public String verifyMonthlyRadioBtnText() {
		
		return monthlyRadioBtnText.getText();

	}

}
