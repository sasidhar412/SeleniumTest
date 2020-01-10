package com.selenium.mobileprize;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainTest {

	WebDriver driver;
	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void mobileRateFinder() throws InterruptedException {
		AmazonRate amazonRate = new AmazonRate();
		FlipkartRate flipkartRate = new FlipkartRate();
		//to get rate from Amazon
		int xphoneAmazonRate = amazonRate.getXphoneRate(driver);
		//to get rate from Flipkart
		int xphoneFlipkartRate = flipkartRate.getXphoneRate(driver);
		if (xphoneAmazonRate < xphoneFlipkartRate) {
			System.out.println("Mobile cost is less in Amazon for Rs." + xphoneAmazonRate);
		} else if (xphoneAmazonRate > xphoneFlipkartRate) {
			System.out.println("Mobile cost is less in Flipkart for Rs." + xphoneFlipkartRate);
		} else
			System.out.println("Mobile cost is same in both the Sites for Rs." + xphoneFlipkartRate);

		driver.close();

	}

}
