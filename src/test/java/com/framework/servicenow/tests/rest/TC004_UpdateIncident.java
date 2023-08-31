package com.framework.servicenow.tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;


public class TC004_UpdateIncident extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Update an Incidentin Servicenow";
		testDescription = "Update an Incident and Verify";
		nodes = "Incident";
		authors = "Sudarshan";
		category = "REST";
		//dataProvider
		dataFileName = "TC004";
		dataFileType = "JSON";
	}

	@Test(dataProvider = "fetchData",dependsOnMethods = "tests.rest.TC001_CreateIncident.createIncident")
	public void UpdateIncident(File file) {		
				
		Response response = putWithFileBodyAndURL(file, "incident/"+sysID);
		verifyContentType(response, "application/json");
		verifyResponseCode(response, 200);
		//verifyContentWithKey(response, "result.short_description", "This is Rest Assured Automation framework - Makaia");
		
	}


}




















