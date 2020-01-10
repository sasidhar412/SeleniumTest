package com.selenium.mobileprize;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepo {

	WebDriver driver;

	ObjectRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBoxId;

	@FindBy(xpath = "//*[@id='nav-search']/form/div[2]/div/input")
	WebElement searchIconXpath;

	@FindBy(xpath = "//*[text()='Apple iPhone XR (64GB) - Yellow']/parent::a/parent::h2/parent::div/parent::div/parent::div/parent::div/following-sibling::div//following-sibling::a/span")
	WebElement productRateXpath;

	@FindBy(xpath = "/html/body/div[2]/div/div/button")
	WebElement popUpCloseXpath;

	@FindBy(xpath = "//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input")
	WebElement searchBox;

	@FindBy(xpath = "//*[text()='Apple iPhone XR (Yellow, 64 GB)']/parent::div/following-sibling::div")
	WebElement productRate;
	
	
	
	
	
	
	
}
