package com.qa.api.gorest.util;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Token {
	
	public static Map<Object,Object> appTokenMap;
	public static Map<String,String> tokenMap = new HashMap<String, String>();
	public static String clientID = "281d1051ff770f3";

	public static Map<Object, Object> getAccessToken() {

		Map<String, String> formParams = new HashMap<String, String>();
		formParams.put("refresh_token", "117551cbdc50f5ef15426b8b163e731523e083a0");
		formParams.put("client_id", "281d1051ff770f3");
		formParams.put("client_secret", "e1f6f90b0dd8bc8738203021394ad789c30449ee");
		formParams.put("grant_type", "refresh_token");

		JsonPath tokenJson = // this will get the comple json response
				given().formParams(formParams)
					.when().post("https://api.imgur.com/oauth2/token")
					.then()
					.extract()
					.jsonPath();

		System.out.println(tokenJson.getMap("")); // get the complete json path

		appTokenMap =  tokenJson.getMap("");
		return appTokenMap;
	}
	
	public static Map<String, String> getAuthToken() {
		
		String authToken = appTokenMap.get("access_token").toString();
		System.out.println("Auth token ===> "+ authToken);
		tokenMap.put("Authorization", "Bearer "+authToken);
		return tokenMap;
		
	}
	
   public static Map<String, String> getClientId() {		
		
		System.out.println("Client id is  ===> "+ clientID);
		tokenMap.put("Authorization", "Client-ID  "+clientID);
		return tokenMap;
		
	}

}
