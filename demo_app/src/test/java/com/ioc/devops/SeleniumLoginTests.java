package com.ioc.devops;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumLoginTests {

	@Test
	public void loginTest() {
//		Create driver using path on the server.
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		System.out.println("Test Started!");
		WebDriver driver = null;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		try {
			driver = new ChromeDriver();
		} catch (IllegalStateException e) {
			// When the driver is not available and exception is thrown then try with local
			// path.
			System.setProperty("webdriver.chrome.driver", "/opt/chromedriver-linux64/chromedriver");
			driver = new ChromeDriver(options);
		}

		System.out.println("Browser started.");
		sleep(2); // Sleep in seconds.
//		open test page
		String url = "http://localhost:8080/demo_app";
		driver.get(url);
		sleep(2); // Sleep in seconds.

		driver.manage().window().maximize();
		sleep(2); // Sleep in seconds.
		System.out.println("Page is Open");

		
		sleep(2); // Sleep in seconds.
//		enter username
		WebElement username = driver.findElement(By.id("uname"));
		username.sendKeys("test");
//		sleep(2); // Sleep in seconds.

//		enter password
		WebElement password = driver.findElement(By.id("psw"));
		password.sendKeys("test");
		sleep(2); // Sleep in seconds.

//		click login button
		WebElement login = driver.findElement(By.id("submit-button"));
		login.click();
//		verification

		String expectedUrl = "http://localhost:8080/demo_app/success.jsp";
		String actualUrl = driver.getCurrentUrl();

		Assert.assertEquals(actualUrl, expectedUrl, "Actural page url is not same as the expected url.");

		sleep(4); // Sleep in seconds.
//		 logout button is visible

//		WebElement logout = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/a[1]"));
//		Assert.assertTrue(logout.isDisplayed(), "Logout button is not displayed.");

//		 succesful login message
		WebElement successMessage = driver.findElement(By.id("message"));

		String expectedMessage = "Login Successful.";
		String actualMessage = successMessage.getText();

//		Assert.assertEquals(actualMessage, expectedMessage, "Login Message not found");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Acutal message does not contain the expected message. \n Acutal:" + actualMessage + "\nExpected:"
						+ expectedMessage);
//		Close Driver
		driver.close();
		System.out.println("Test Finished!");
//		
	}

	/**
	 * Stops execution for the given amount of seconds.
	 * 
	 * @param seconds
	 */
	private void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
