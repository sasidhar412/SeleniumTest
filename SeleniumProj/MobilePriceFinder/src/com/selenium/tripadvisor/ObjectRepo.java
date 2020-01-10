package com.selenium.tripadvisor;

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

	@FindBy(xpath = "//*[@class='ui_icon search brand-global-nav-action-search-Search__icon--2DVjd']")
	WebElement homeSearch;
	
	@FindBy(xpath = "//*[@id='mainSearch']")
	WebElement mainSearch;
	
	@FindBy(xpath = "//*[@class='resultContainer local']/child::li[1]")
	WebElement selectFromList;

	@FindBy(xpath = "//*[text()='Write a review']")
	WebElement writeAReview;
	
	@FindBy(xpath = "//*[@id='bubble_rating']")
	WebElement bubbleRating;

	@FindBy(xpath = "//*[@id='ReviewTitle']")
	WebElement reviewTitle;

	@FindBy(xpath = "//*[@id='ReviewText']")
	WebElement reviewText;

	@FindBy(xpath = "//*[@id='trip_type_table']/div[1]")
	WebElement tripType;

	@FindBy(name = "trip_date_month_year")
	WebElement tripIn;

	@FindBy(id = "noFraud")
	WebElement noFraudCheck;

	@FindBy(xpath = "//*[@id='DQ_RATINGS']/div[1]")
	WebElement hotelRatings;

	
	@FindBy(xpath = "//*[text()='Hotel Ratings']/following-sibling::div[1]/child::div[1]/child::div[2]/child::div/span")
	WebElement firstOne;
	
	@FindBy(xpath = "//*[text()='Hotel Ratings']/following-sibling::div[1]/child::div[2]/child::div[2]/child::div/span")
	WebElement secondOne;
	
	@FindBy(xpath = "//*[text()='Hotel Ratings']/following-sibling::div[1]/child::div[3]/child::div[2]/child::div/span")
	WebElement thirdRating;
	
	
	
}
