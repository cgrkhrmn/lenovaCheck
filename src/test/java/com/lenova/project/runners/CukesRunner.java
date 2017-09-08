package com.lenova.project.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "json:target/cucumber-reports",
		features = "./src/test/resources/features/",
		glue = "com.lenova.project.stepDefinitions",
		tags = "@lenova",
		dryRun = false
		)
public class CukesRunner {

}
//test -Dcucumber.option="--tags @lenova"
///Users/cagrikahraman/Documents/workspace/Lenova/pom.xml