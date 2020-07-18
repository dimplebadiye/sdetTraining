package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.Hooks;

public class HomePage extends Hooks {

private WebDriverWait wait = new WebDriverWait(driver, 30);
	
	public WebElement getAdminstrationLink() {
		return driver.findElement(By.xpath("//a[contains(text(), 'Administration')]"));
	}
	
	public WebElement getClassesLink() {
		return driver.findElement(By.xpath("//a[contains(text(), 'Classes')]"));
	}
	
	public boolean validateUserIsOnHomePage() {
		boolean result = false;
		try {
			result = driver.findElement(By.className("homepage active")) != null;
		} catch (Exception e) {
			driver.findElement(By.xpath("//a[contains(text(), 'Homepage')]")).click();
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[contains(text(), 'Homepage')]"))));
			result = driver.findElement(By.xpath("//a[contains(text(), 'Homepage')]")) != null;
		}
		return result;
	}

	public WebElement getSiteOwnerLink() {
		return driver.findElement(By.xpath("//li[@class = 'dropdown avatar-user']/a"));
	}
	
	public WebElement getLogoutLink() {
		return driver.findElement(By.id("logout_button"));
	}
}