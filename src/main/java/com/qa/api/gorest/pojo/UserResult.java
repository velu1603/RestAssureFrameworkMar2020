package com.qa.api.gorest.pojo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.qa.api.gorest.util.*;

import come.qa.api.gorest.restclient.RestClient;
import io.restassured.response.Response;



public class UserResult {

	
	
	@Test	
	public void createUserWithFullJson() {
		String token = "WOBpAiphQaBqn6gg_gsjiswFg2Szp1wc-o_B";
		
	Self sf = new Self("http://www.sf.com");
	Edit ed = new Edit("http://www.ed.com");
	Avatar av = new Avatar("http://www.av.com");
	
	Links ln = new Links(sf, ed, av);
	
	
	UserInfo uf = new UserInfo("Tom", "Peter", "male", "09-09-989", "tom1111999123@gmail.com", "90898777819", "http://www.tomcat1.com", 
								"test address11", "active", ln);
	
	String UserJsonPayLoad = TestUtil.getSerializedJSON(uf);
	System.out.println("JSON  :"+ UserJsonPayLoad);
	
	Map<String,String> authTokenMap = new HashMap<String, String>();
	authTokenMap.put("Authorization", "Bearer "+ token);
	
	Response response = RestClient.doPost("JSON", "https://gorest.co.in", "/public-api/users", authTokenMap, null, true, UserJsonPayLoad);
	
	System.out.println(response.getStatusCode());
	System.out.println(response.prettyPrint());
   }
	
}
