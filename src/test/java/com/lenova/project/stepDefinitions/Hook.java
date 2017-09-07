package com.lenova.project.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.lenova.project.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

	@Before
	public void setUp() {
		Driver.getInstance().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) 
					Driver.getInstance()).getScreenshotAs(OutputType.BYTES);
			
			scenario.embed(screenshot, "image/png");
		}
		Driver.closeDriver();
	}

}
