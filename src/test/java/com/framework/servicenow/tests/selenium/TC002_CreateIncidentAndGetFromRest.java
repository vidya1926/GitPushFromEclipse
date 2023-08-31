package com.framework.servicenow.tests.selenium;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;
import com.framework.selenium.api.base.PreAndPost;
import com.framework.selenium.servicenow.pages.LoginPage;
import com.framework.utils.HTMLReporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC002_CreateIncidentAndGetFromRest extends PreAndPost{

	@BeforeTest
	public void setValues() {

		testCaseName = "Create Incident and Verify";
		testDescription = "Create Incident (Using Selenium) and Verify using REST";
		nodes = "Incident Management";
		authors = "Shiva";
		category = "UI & API";
		dataSheetName = "TC002";

	}

	@Test(dataProvider = "fetchData")
	public void createIncident(String filter, String user, String short_desc) throws InterruptedException {
		
		// Selenium - Create Incident		
		new LoginPage(driver,test)
		.loginApp()
		.searchUsingFilter(filter)
		.clickCreateNew()
		.clickNewButton()
		.getIncidentNumber()// get incident number
		.selectUser(user)
		.typeShortDescription(short_desc)
		.clickSubmit();
		
		
		// Verify Using REST Assured		
		Response response = RESTAssuredBase.get("incident?number="+incidentNumber);
		response.prettyPrint();
		RESTAssuredBase.verifyResponseCode(response, 200);
		RESTAssuredBase.verifyContentsWithKey(response, "result.number",incidentNumber);
	}


}





