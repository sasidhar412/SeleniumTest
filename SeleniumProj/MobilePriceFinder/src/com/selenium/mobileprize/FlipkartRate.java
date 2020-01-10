package com.selenium.mobileprize;

import org.openqa.selenium.WebDriver;

public class FlipkartRate {
	
	private String flipkartUrl = "https://www.flipkart.com/";
	private String searchText = "iPhone XR (64GB) - Yellow";
	ObjectRepo objRepo;
	
public int getXphoneRate(WebDriver driver) throws InterruptedException{
	objRepo = new ObjectRepo(driver);
	
	//To load Flipkart site
	 driver.get(flipkartUrl);
	 
	 //to close login pop-up
	 if(objRepo.popUpCloseXpath.isDisplayed()){
		 objRepo.popUpCloseXpath.click(); 
	 }else{}

	 //to search mobile model
	 objRepo.searchBox.sendKeys(searchText);
	 objRepo.searchBox.submit();
	 Thread.sleep(5000);
	 
	 String text = objRepo.productRate.getText();
	 String[] s = text.split(",|\\₹");
	 String flipRate = s[1]+s[2];
	 System.out.println("Prize in Flipkart: Rs."+flipRate);
	 return Integer.parseInt(flipRate);
}


}
