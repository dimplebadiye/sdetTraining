package com.stepDefination;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.pageObject.ClassesPage;
import com.pageObject.HomePage;
import com.pageObject.SubscribeClassToCoursesPage;
import com.pageObject.SubscribeClassToSessionsPage;
import com.pageObject.SubscribeUsersToClassPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ELSC_011Steps {

	private String existingCountOfUsers;
	private String existingCountOfCourses;
	private String existingCountOfUsersSessions;
	private HomePage home = new HomePage();
	private ClassesPage classes = new ClassesPage();
	private SubscribeUsersToClassPage subscribeUsersToClass = new SubscribeUsersToClassPage();
	private SubscribeClassToCoursesPage subscribeClassToCourses = new SubscribeClassToCoursesPage();
	private SubscribeClassToSessionsPage subscribeClassToSessions = new SubscribeClassToSessionsPage();
	
	@And("^user is on Home page$")
	public void validateUserIsOnHomePage() throws Throwable {
		assertTrue("User is not on Home page", home.validateUserIsOnHomePage());
	}
	
	@When("^user click 'Administration' tab$")
	public void navigateToAdministrationTab() throws Throwable {
		home.getAdminstrationLink().click();
	}
	
	@And("^users select 'Classes' under Users section$")
	public void clickClasses() throws Throwable {
		home.getClassesLink().click();
	}
	
	@And("^user click 'Add classes' icon$")
	public void clickAddClasses() throws Throwable {
		classes.getAddClassesIcon().click();
	}
	
	@And("^user enter Name: '(.*)'$")
	public void enterName(String name) throws Throwable {
		classes.getNameField().sendKeys(name);
	}
	
	@And("^user enter Description: '(.*)'$")
	public void enterDescription(String description) throws Throwable {
		classes.getDescriptionField().sendKeys(description);
	}
	
	@And("^user selects '(.*)' from 'Group Permision' dropdown$")
	public void selectGroupPermission(String option) throws Throwable {
		classes.getDropDownButton().click();
		classes.getOpenOption().click();
	}
	
	@And("^user click 'Add' button$")
	public void clickAddButton() throws Throwable {
		classes.getAddButton().click();
	}
	
	@And("^user locates newly added class '(.*)'$")
	public void navigateToClass(String className) throws Throwable {
		classes.navigateToClass(className);
	}
	
	@And("^if the class already exist get users, courses and sessions count$")
	public void getExistingCount() {
		existingCountOfUsers = classes.users;
		existingCountOfCourses = classes.courses;
		existingCountOfUsersSessions = classes.sessions;
	}
	
	@And("^user click 'Subscribe user to class' icon$")
	public void clickSubscribeUserToClassIcon() throws Throwable {
		classes.subscribeUsersToClass.click();
	}
	
	@And("^select users from 'Users on platform' section and add to 'Users in group' section$")
	public void addUsersInGroup() throws Throwable {
		subscribeUsersToClass.addUsersInGroup();
	}
	
	@And("^click 'Subscribe Users to class' button$")
	public void clickSubscribeUsersToClassButton() throws Throwable {
		subscribeUsersToClass.getSubscribeUsersToClassButton().click();
	}
	
	@And("^user click 'Subscribe class to courses' icon$")
	public void clickSubscribeclassToCoursesIcon() throws Throwable {
		classes.subscribeClassToCourses.click();
	}
	
	@And("^select cources from 'Courses on the platform' section and add to 'Courses in group' section$")
	public void addCoursesInGroup() throws Throwable {
		subscribeClassToCourses.addCoursesInGroup();
	}
	
	@And("^click 'Subscribe class to courses' button$")
	public void clickSubscribeClassToCoursesButton() throws Throwable {
		subscribeClassToCourses.getSubscribeClassToCoursesButton().click();
	}
	
	@And("^user click 'Subscribe class to sessions' icon$")
	public void clickSubscribeClassToSessionsIcon() throws Throwable {
		classes.subscribeClassToSessions.click();
	}
	
	@And("^select sessions from 'Sessions not subscribed' section and add to 'Sessions in group' section$")
	public void addSessionsInGroup() throws Throwable {
		subscribeClassToSessions.addSessionsInGroup();
	}
	
	@And("^click 'Subscribe class to sessions' button$")
	public void clickSubscribeClassToSessionsButton() throws Throwable {
		subscribeClassToSessions.getSubscribeUsersToClassButton().click();
	}
	
	@Then("^selected course should get subscribe to the class & number of courses subscribed should get displayed in courses$")	
	public void validateClassDetails() throws Throwable {
		int expectedUsers = Integer.valueOf(existingCountOfUsers) + 15;
		int expectedCourse = Integer.valueOf(existingCountOfCourses) + 15;
		int expectedSessions = Integer.valueOf(existingCountOfUsersSessions) + 15;
		assertEquals("Number of users not equal", String.valueOf(expectedUsers),  classes.users);
		assertEquals("Number of courses not equal", String.valueOf(expectedCourse), classes.courses);
		assertEquals("Number of sessions not equal", String.valueOf(expectedSessions), classes.sessions);
	}
	
	@And("^user Logout of 'eLearning' site$")
	public void logout() throws Throwable {
		home.getSiteOwnerLink().click();
		home.getLogoutLink().click();
	}
	
	@And("^user enter data in 'Add classes' page$")
	public void enterDataInAddClassesPage() throws Throwable {
		classes.enterDataInAddClassesPage();
	}
}