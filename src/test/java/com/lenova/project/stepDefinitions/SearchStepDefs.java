package com.lenova.project.stepDefinitions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lenova.project.pages.HomePage;
import com.lenova.project.utilities.ConfigurationReader;
import com.lenova.project.utilities.Driver;



public class SearchStepDefs {
	static HomePage homePage = new HomePage();
	WebElement i7 = homePage.i7;
	List<Integer> arrDropedPrices = new ArrayList<>();
	List<Integer> arrListedPrices = new ArrayList<>();
	static WebDriver driver = Driver.getInstance();

	@BeforeClass
	public static void setUp() {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Driver.getInstance().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Test
	public void test1() {
		homePage.laptops.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(homePage.processer));
		homePage.processer.click();
		wait.until(ExpectedConditions.visibilityOf(i7));
		i7.click();
		try{
			wait.until(ExpectedConditions.visibilityOf(homePage.surveyFrame));
		driver.switchTo().frame(homePage.surveyFrame);
		homePage.closePrompt.click();
		}catch (Exception e) {
			//System.out.println("alert didn't pop up");
		}
		List<WebElement> dropedPrices = homePage.dropPrice;
		//System.out.println("Drop prices are " + dropedPrices.size());
		String tempDropPrice;
		int tempDropPriceInt;
		List<WebElement> listPrices = homePage.listedPrice;
		//System.out.println("Listed prices are " + listPrices.size());
		String tempListPrice;
		int tempListPriceInt;

		String now = LocalDateTime.now().toString();
		System.out.println("Price check time : "+now);
		
		for (int i = 0; i < dropedPrices.size(); i++) {
			int DropPriceLength=dropedPrices.get(i).getText().length();
			if(DropPriceLength>0){
			try {
				tempDropPrice = dropedPrices.get(i).getText().substring(1, 4);
				tempDropPriceInt = Integer.parseInt(tempDropPrice);
				// System.out.println("the parsed price is "+tempDropPriceInt);
				if (tempDropPriceInt < 400) {
					arrDropedPrices.add(tempDropPriceInt);
					
					System.out.println("Laptop number "+i+"'s price is "+tempDropPrice);
					
				} else {
					System.out.println("there is no computer droped price less then $400");
					break;
				}

			} catch (Exception e) {
				System.out.println("there is a problem");
			}
			}else{
				System.out.println("There is no droped price lower than $400");
			}
			}
		
		
		//System.out.println("Listed prices are started");

		for (int i = 0; i < listPrices.size(); i++) {
			int ListPriceLength=listPrices.get(i).getText().length();
			if(ListPriceLength>0){
			try {
				tempListPrice = listPrices.get(i).getText().substring(1, 4);
					tempListPriceInt = Integer.parseInt(tempListPrice);
					
				
				// System.out.println("the parsed price is "+tempListPriceInt);
				if (tempListPriceInt < 400) {
					arrListedPrices.add(tempListPriceInt);
					System.out.println("Laptop number "+i+"'s price is "+tempListPrice);
				} else {
					System.out.println("there is no computer listed price less then $400");
					break;
				}
			}

			 catch (Exception e) {
				System.out.println("there is a problem");
			}
			}else{
				System.out.println("There is no Listed price lower than $400");
			}
			

}

}
	@AfterClass
	public static void tearDown(){
		driver.close();
	}
}
