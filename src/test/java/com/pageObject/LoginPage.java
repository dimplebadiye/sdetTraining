package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.Hooks;

public class LoginPage extends Hooks{

	public WebElement getUserNameField() {
		return driver.findElement(By.id("login"));
	}
	
	public WebElement getPasswordField() {
		return driver.findElement(By.id("password"));
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(By.id("form-login_submitAuth"));
	}
	
	public void navigateToSite() {
		driver.get("http://elearningm1.upskills.in/index.php");
	}
}