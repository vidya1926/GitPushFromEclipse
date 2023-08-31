package com.framework.servicenow.tests.selenium;

import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;
import com.framework.selenium.api.base.PreAndPost;
import com.framework.selenium.servicenow.pages.LoginPage;
import com.framework.utils.HTMLReporter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC003_CreateIncidentUsingRestAndVerifyUsingSelenium extends PreAndPost{

	@BeforeTest
	public void setValues() {

		testCaseName = "Search Incident (Using Selenium) After Creating Incident (Using REST Assured)";
		testDescription = "Create Incident (Using REST Assured) and Search with Selenium";
		nodes = "Incident Management";
		authors = "Shiva";
		category = "UI & API";
		dataSheetName = "TC003";

	}

	@Test(dataProvider = "fetchData")
	public void createIncident(String filter) throws InterruptedException {

		// Post the request
		Response response = RESTAssuredBase.post("incident",ContentType.JSON);

		RESTAssuredBase.verifyResponseCode(response, 201);
		
		response.prettyPrint();

	

		// Selenium - find Incident
		new LoginPage(driver,test)
			.loginApp()
			.searchUsingFilter(filter)
			.clickOpen()
			.selectSearchDD("Number")
			.typeAndEnterSearch(incidentNumber);
	
	}


}





