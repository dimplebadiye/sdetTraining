package com.test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "./res/features",
	glue= {"com.stepDefination", "com.utility"})
public class TestRunner {

}
