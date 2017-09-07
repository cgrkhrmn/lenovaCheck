package com.lenova.project.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lenova.project.utilities.Driver;


public class HomePage {

	public HomePage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}
	
	@FindBy(xpath="//a[@href='/us/en/outletus/c/LAPTOPS/']")
	public WebElement laptops;
	
	@FindBy(xpath="(//input[@type='checkbox'])[17]")
	public WebElement i7;
	
	@FindBy(id="facet-list-item-2")
	public WebElement processer;
	
	@FindBy(xpath="//dd[@itemprop='price']")
	public List<WebElement> dropPrice;
	
	@FindBy(xpath="//dd[@itemprop='listPrice']")
	public List<WebElement> listedPrice;
	
	@FindBy(id="destination_publishing_iframe_lenovo_0")
	public WebElement surveyFrame;
	
	@FindBy(id="oo_close_prompt")
	public WebElement closePrompt;



}
