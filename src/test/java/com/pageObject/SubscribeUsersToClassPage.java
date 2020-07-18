package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utility.Hooks;

public class SubscribeUsersToClassPage extends Hooks {

	public Select getUsersOnPlatform() {
		Select usersOnPlatform = new Select(driver.findElement(By.id("elements_not_in")));
		return usersOnPlatform;
	}
	
	public WebElement getAddUsersArrow() {
		return driver.findElement(By.xpath("//div[@class = 'col-md-2']//button[1]"));
	}
	
	public WebElement getSubscribeUsersToClassButton() {
		return driver.findElement(By.xpath("//button[@class = 'btn btn-primary']"));
	}
	
	public void addUsersInGroup() throws Throwable {
		int i = 0;
		Select usersOnPlatform = getUsersOnPlatform();
		while(i < 15) {
			usersOnPlatform.selectByIndex(i);
			getAddUsersArrow().click();
			i++;
		}
		Thread.sleep(3000);
	}
}