package com.selenium.tripadvisor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TripTest {
	
	WebDriver driver;
	ObjectRepo objRepo;
	String tripAdvisorUrl="https://www.tripadvisor.in/";
	String textToSearch = "Club Mahindra";
	String reviewTitle = "Self contained family resort";
	String reviewText = "Its a very huge property and very well maintained. There is a grocery store inside the resort incase you want to buy anything . The rooms are big and spacious and even have a kitchenette depending on the room chosen by you. It also has a big swimming pool with paid activities like zorbing. There are also other paid activities like atv ride, zip lining, etc. The hospitality is top notch. It is better if you have a membership number as there are benefits on buffet meals as well as a la carte.";
	
	@BeforeClass
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		//Initializing Chrome Web Driver
		 driver = new ChromeDriver();
		 objRepo = new ObjectRepo(driver);
		 // to open Trip Advisor site
		driver.get(tripAdvisorUrl);
	}
	
	@Test
	public void test() throws Exception {
		driver.manage().window().maximize();
		long timeout=5;
		driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS);
		
		//To search hotel 
		objRepo.homeSearch.click();
		objRepo.mainSearch.sendKeys(textToSearch);
		objRepo.selectFromList.click();
		Thread.sleep(2000);
		
		//to click write a review
		objRepo.writeAReview.click();
		
		//To get current available windows
		List<String> windowHandles=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		
		//to give 5 * ratings by mouse hover
		Actions actions = new Actions(driver);
		actions.moveToElement(objRepo.bubbleRating).click(objRepo.bubbleRating).build().perform();
		actions.moveByOffset(50, 0).click().build().perform();
		objRepo.reviewTitle.sendKeys(reviewTitle);
		objRepo.reviewText.sendKeys(reviewText);
		objRepo.tripType.click();
		Select dropDown = new Select(objRepo.tripIn);
		dropDown.selectByIndex(1);
		
		// rate if only Hotel Rating section is available
		if(objRepo.hotelRatings.getText().equals("Hotel Ratings")){
			actions.moveToElement(objRepo.firstOne).click(objRepo.firstOne).build().perform();
			actions.moveByOffset(50, 0).click().build().perform();
			actions.moveToElement(objRepo.secondOne).click(objRepo.secondOne).build().perform();
			actions.moveByOffset(50, 0).click().build().perform();
			actions.moveToElement(objRepo.thirdRating).click(objRepo.thirdRating).build().perform();
			actions.moveByOffset(50, 0).click().build().perform();
		}

		//to click check box
		objRepo.noFraudCheck.click();
	}
}
