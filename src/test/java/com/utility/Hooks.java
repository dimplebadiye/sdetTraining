package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	public static WebDriver driver;
	
	@Before
    public void beforeScenario(){
		System.setProperty("webdriver.chrome.driver", "./res/drivers/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    }	
	
	@After
    public void afterScenario(){
        driver.quit();
    }
}
