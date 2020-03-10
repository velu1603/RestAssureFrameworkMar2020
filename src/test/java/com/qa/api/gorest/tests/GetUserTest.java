package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import come.qa.api.gorest.restclient.RestClient;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

@Epic("EPIC-101: get user go rest api feature implementation....")
@Feature("US-1001: get user api feature....")
public class GetUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "WOBpAiphQaBqn6gg_gsjiswFg2Szp1wc-o_B";
	
	@Description("get all user lists api test with query params,,Verify all users list from get call.....")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1)
	public void getAllUserListAPITest() {
		
		Map<String,String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer "+ token);
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, null, true);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}

	@Description("get all user lists api test with query params,,Verify all users list from get call.....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 2)
	public void getUserWithQueryParamsAPITest() {
		
		Map<String,String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer "+ token);
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("first_name", "John");
		params.put("gender","male");
		
		
		Response response = RestClient.doGet("JSON", baseURI, basePath, authTokenMap, params, true);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}
}
