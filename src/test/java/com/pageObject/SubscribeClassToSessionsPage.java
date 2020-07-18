package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utility.Hooks;

public class SubscribeClassToSessionsPage extends Hooks {
	
	public Select getSessionNotSubscribed() {
		Select sessionsNotSubscribed = new Select(driver.findElement(By.name("elements_not_in_name")));
		return sessionsNotSubscribed;
	}
	
	public WebElement getAddSessionsArrow() {
		return driver.findElement(By.xpath("//select[@id = 'elements_not_in']/ancestor::td/following-sibling::td/button[1]"));
	}
	
	public WebElement getSubscribeUsersToClassButton() {
		return driver.findElement(By.xpath("//button[@class = 'btn btn-primary']"));
	}
	
	public void addSessionsInGroup() throws Throwable {
		int i = 0;
		Select sessionNotSubscribed = getSessionNotSubscribed();
		while(i < 15) {
			sessionNotSubscribed.selectByIndex(i);
			getAddSessionsArrow().click();
			i++;
		}
		Thread.sleep(3000);
	}
}