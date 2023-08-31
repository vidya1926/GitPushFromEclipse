package com.framework.servicenow.tests.rest;

import java.io.File;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.restassured.api.base.RESTAssuredBase;

import io.restassured.response.Response;


public class TC002_GetIncidents extends RESTAssuredBase{
	
	@BeforeTest//Reporting
	public void setValues() {
		testCaseName = "Get All Incidents";
		testDescription = "Get All incidents";
		nodes = "Incident";
		authors = "Sudarshan";
		category = "REST";
	}

	@Test
	public void getIncident() {		
				
		Response response = get("incident");
		response.prettyPrint();
		verifyContentType(response, "application/json");
		verifyResponseCode(response, 200);
		
		
	}


}




















