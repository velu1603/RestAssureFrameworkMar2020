package com.qa.api.gorest.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.util.ExcelUtil;

import come.qa.api.gorest.restclient.RestClient;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;

@Epic("EPIC -102: Create user go rest api feature implementation....")
@Feature("US-1002: Create user api feature....")
public class CreateUserTest {
	
	String baseURI = "https://gorest.co.in";
	String basePath = "/public-api/users";
	String token = "WOBpAiphQaBqn6gg_gsjiswFg2Szp1wc-o_B";
	
	@DataProvider 
	public Object[][] getUserData() {
		
		Object userData[][] = ExcelUtil.getTestData("userdata");
		return userData;
	}	
	
	@Description("crete user lists api test ....,Verify create users list from POST call.....")
	@Severity(SeverityLevel.BLOCKER)
	@Test(dataProvider = "getUserData") // use the name of the dataprovider method
	public void createUserAPIPOSTTest(String firstname,String lastname,String gender,String dob,String email,String phonenumber,String website,String address,String status) {
		
		Map<String,String> authTokenMap = new HashMap<String, String>();
		authTokenMap.put("Authorization", "Bearer "+ token);
		
		
		User user = new User(firstname,lastname, gender, dob, email, phonenumber, website, address, status);
		
		Response response = RestClient.doPost("JSON", baseURI, basePath, authTokenMap, null, true, user);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println("==============================================================================");
	}
}
