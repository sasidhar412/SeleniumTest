package com.selenium.mobileprize;

import org.openqa.selenium.WebDriver;

public class AmazonRate {

	
	private String amazonUrl = "https://www.amazon.in/";
	private String searchText = "iPhone XR (64GB) - Yellow";
	ObjectRepo objRepo;
	
	public int getXphoneRate(WebDriver driver) throws InterruptedException{
		 objRepo = new ObjectRepo(driver);
		 
		 //To load Amazon site
		 driver.get(amazonUrl);
		 driver.manage().window().maximize(); 
		 objRepo.searchBoxId.sendKeys(searchText);
		 objRepo.searchIconXpath.click();
		 String textRate = objRepo.productRateXpath.getText();
		 String[] split = textRate.split(",|\\₹");
		 String rate=split[1]+""+split[2];
		 System.out.println("Prize in Amazon: Rs."+rate);
		 return Integer.parseInt(rate);
	}
	
}
