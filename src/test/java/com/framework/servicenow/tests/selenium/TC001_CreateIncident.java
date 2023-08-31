package com.framework.servicenow.tests.selenium;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.selenium.api.base.PreAndPost;
import com.framework.selenium.servicenow.pages.LoginPage;

public class TC001_CreateIncident extends PreAndPost{

	@BeforeTest
	public void setValues() {

		testCaseName = "Create Incident (Using Selenium)";
		testDescription = "Create a new Incident";
		nodes = "Incident Management";
		authors = "Sarath";
		category = "UI";
		dataSheetName = "TC002";

	}

	@Test(dataProvider = "fetchData")
	public void createIncident(String filter, String user, String short_desc) throws InterruptedException {
		
		new LoginPage(driver, test)
		.loginApp()
		.searchUsingFilter(filter)
		.clickCreateNew()
		.getIncidentNumber()
		.selectUser(user)
		.typeShortDescription(short_desc)
		.clickSubmit();
		
	}


}





