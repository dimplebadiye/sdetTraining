package com.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.utility.Hooks;
import com.utility.ReadTestDataFile;

public class ClassesPage extends Hooks {
	
	public String users;	 
	public String courses;
	public String sessions;
	public WebElement subscribeUsersToClass;
	public WebElement subscribeClassToCourses;
	public WebElement subscribeClassToSessions;
	private ReadTestDataFile testData = new ReadTestDataFile();
	
	public WebElement getAddClassesIcon() {
		return driver.findElement(By.xpath("//img[@title = 'Add classes']/parent::a"));
	}
	
	public WebElement getNameField() {
		return driver.findElement(By.id("usergroup_name"));
	}
	
	public WebElement getDescriptionField() {
		return driver.findElement(By.id("usergroup_description"));
	}
	
	public WebElement getDropDownButton() {
		return driver.findElement(By.xpath("//button[@class = 'btn dropdown-toggle btn-default']"));
	}
	
	public WebElement getOption(String option) {
		return driver.findElement(By.xpath("//span[text() = '" + option + "']/parent::a"));
	}
	
	public WebElement getAddButton() {
		return driver.findElement(By.id("usergroup_submit"));
	}
	
	public List<WebElement> getClassDetails(){
		return driver.findElements(By.xpath("//table[@id = 'usergroups']//tr"));
	}
	
	public WebElement getNextArrow() {
		return driver.findElement(By.id("next_usergroups_pager"));
	}
	
	public void navigateToClass(String className) {
		boolean result = false;
		try {
			do {
				List<WebElement> classDetails = getClassDetails();
				for(int i = 0; i < classDetails.size(); i++) {
					if(driver.findElement(By.xpath("//table[@id = 'usergroups']//tr[" + (i + 1) + "]/td[1]")).getAttribute("title").equals(className)) {
						users = driver.findElement(By.xpath("//table[@id = 'usergroups']//tr[" + (i + 1) + "]/td[1][@title = '" + className + "']/following-sibling::td[1]/a")).getText();
						courses = driver.findElement(By.xpath("//table[@id = 'usergroups']//tr[" + (i + 1) + "]/td[1][@title = '" + className + "']/following-sibling::td[2]")).getText();
						sessions = driver.findElement(By.xpath("//table[@id = 'usergroups']//tr[" + (i + 1) + "]/td[1][@title = '" + className + "']/following-sibling::td[3]")).getText();
						subscribeUsersToClass = driver.findElement(By.xpath("//table[@id = 'usergroups']//tr[" + (i + 1) + "]/td[1][@title = '" + className + "']/following-sibling::td[5]//img[@title = 'Subscribe users to class']/parent::a"));
						subscribeClassToCourses = driver.findElement(By.xpath("//table[@id = 'usergroups']//tr[" + (i + 1) + "]/td[1][@title = '" + className + "']/following-sibling::td[5]//img[@title = 'Subscribe class to courses']/parent::a"));
						subscribeClassToSessions = driver.findElement(By.xpath("//table[@id = 'usergroups']//tr[" + (i + 1) + "]/td[1][@title = '" + className + "']/following-sibling::td[5]//img[@title = 'Subscribe class to sessions']/parent::a"));
						result = true;
						break;
					}
				}
				if(result == true)
					break;
				else {
					getNextArrow().click();
					Thread.sleep(3000);
				}
			} while (!(getNextArrow().getAttribute("class").equals("ui-pg-button ui-corner-all ui-state-disabled")));
		} catch (Exception e) {
			System.out.print("Class not created / not found");
		}
		
	}
	
	public void enterDataInAddClassesPage() throws Throwable {
		List<String> inputs = testData.readExcel();
		getNameField().sendKeys(inputs.get(0));
		getDescriptionField().sendKeys(inputs.get(1));
		getDropDownButton().click();
		getOption(inputs.get(2)).click();
	}
}