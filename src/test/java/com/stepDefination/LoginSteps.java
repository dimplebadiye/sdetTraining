package com.stepDefination;

import com.pageObject.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class LoginSteps {
	
	private LoginPage login = new LoginPage();
	
	@Given("^user navigate to eLearning site$")
	public void navigateToELearningSite() {
		login.navigateToSite();
	}
	
	@And("^user enter Username: '(.*)'$")
	public void enterUsername(String username) {
		login.getUserNameField().sendKeys(username);
	}
	
	@And("^user enter Password: '(.*)'$")
	public void EnterPassword(String password) {
		login.getPasswordField().sendKeys(password);
	}
		
	@And("^user click 'Login' button$")
	public void clickLoginButton() {
		login.getLoginButton().click();
	}
	
}