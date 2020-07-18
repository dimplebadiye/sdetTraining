package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.utility.Hooks;

public class SubscribeClassToCoursesPage extends Hooks {

	public Select getCoursesOnThePlatform() {
		Select coursesOnThePlatform = new Select(driver.findElement(By.id("elements_not_in")));
		return coursesOnThePlatform;
	}
	
	public WebElement getAddCourseArrow() {
		return driver.findElement(By.xpath("//select[@id = 'elements_not_in']/ancestor::td/following-sibling::td/button[1]"));
	}
	
	public WebElement getSubscribeClassToCoursesButton() {
		return driver.findElement(By.xpath("//button[text() = 'Subscribe class to courses']"));
	}
	
	public void addCoursesInGroup() throws Throwable {
		int i = 0;
		Select courcesOnPlatform = getCoursesOnThePlatform();
		while(i < 15) {
			courcesOnPlatform.selectByIndex(i);
			getAddCourseArrow().click();
			i++;
		}
		Thread.sleep(3000);
	}
}