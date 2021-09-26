package test.java.com.nadella.Assessment.testcases;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import main.java.com.nadella.Assessment.pageobjects.AspirationHomePage;
import main.java.com.nadella.Assessment.pageobjects.GetAspirationPlusProductPage;
import main.java.com.nadella.Assessment.pageobjects.GetAspirationProductPage;
import main.java.com.nadella.Assessment.pageobjects.SpendAndSavePlansPage;

public class AspirationValidationsTest extends Base {	

	private static Logger log = LogManager.getLogger(AspirationValidationsTest.class);

	@Test
	public void clickSpendAndSaveLink() throws InterruptedException {
		driver.get(baseUrl);
		log.info("Entered Aspiration URL");

		// Verify that as a user, they can view our products and prices by navigating
		// from the home page to our products page via the “Spend & Save” link at the
		// top of the home page
		AspirationHomePage aHome = new AspirationHomePage(driver);
		aHome.clickSpendSave().click();
		log.info("Click on Spend & Save link");

		// Verify that you see 2 card products, Aspiration and Aspiration Plus
		SpendAndSavePlansPage plans = new SpendAndSavePlansPage(driver);
		boolean verifyAspiration = plans.getAspiration().isDisplayed();
		log.info("checking for Aspiration product");
		log.info(verifyAspiration);
		boolean verifyAspirationPlus = plans.getAspirationPlus().isDisplayed();
		log.info("checking for Aspiration Plus product");
		log.info(verifyAspirationPlus);

		// Verify that when you click Get Aspiration - A modal containing an input field	
		// for an email address to sign up appears. You do not need to sign up.
		plans.getAspiration().click();
		log.info("Click on Aspiration product link");

		GetAspirationProductPage aspirationProduct = new GetAspirationProductPage(driver);

		// aspirationProduct.
		aspirationProduct.switchToAlert();
		log.info("New window popup opened for Aspiration Product");
		boolean verifyEmailTxtbox = aspirationProduct.email().isDisplayed();
		log.info("Checking for email text box in Aspiration product popup: "+ verifyEmailTxtbox);
		aspirationProduct.closeAlert().click();
		log.info("Aspiration Product popup closed");

		// Verify that when you click Get Aspiration Plus - A modal with monthly and
		// yearly plans appears

		plans.getAspirationPlus().click();
		log.info("Click on Aspiration Plus product link");
		// aspirationProductPlus pop up.
		aspirationProduct.switchToAlert();
		log.info("New window popup opened for Aspiration Plus plan");
		GetAspirationPlusProductPage aspirationPlusProduct = new GetAspirationPlusProductPage(driver);
		Thread.sleep(1000);

		boolean verifyYearlyRadioBtn = aspirationPlusProduct.verifyYearlyRadioBtns().isDisplayed();
		log.info("verifying the yearly radio button: "+verifyYearlyRadioBtn);
		
		boolean verifyMonthlyRadioBtn = aspirationPlusProduct.verifyMonthlyRadioBtns().isDisplayed();
		log.info("verifying the monthly radio button: " + verifyMonthlyRadioBtn);
		
		
		//Verify that yearly radio option is $71.88 paid once yearly
		log.info(aspirationPlusProduct.verifyYearlyRadioBtnText());
		//Verify that monthly radio option is $7.99 paid monthly
		
		log.info(aspirationPlusProduct.verifyMonthlyRadioBtnText());
		
		
		log.info("Validating yearly radio option text. Is expected and actual same? " + aspirationPlusProduct.verifyYearlyRadioBtnText().contains("$71.88 paid once yearly"));
		assertTrue(aspirationPlusProduct.verifyYearlyRadioBtnText().contains("$71.88 paid once yearly"));
		  
		log.info("Validating monthly radio option text. Is expected and actual same? "+aspirationPlusProduct.verifyMonthlyRadioBtnText().contains("$7.99 paid monthly"));
		assertTrue(aspirationPlusProduct.verifyMonthlyRadioBtnText().contains("$7.99 paid monthly"));
		  
	}

}
