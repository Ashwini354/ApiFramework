package com.test.tests;

import org.testng.annotations.Test;

import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class AddUserDataTest {
	UserServiceHelper user = new UserServiceHelper();
	ReusableMethods reusable=new ReusableMethods();

	@Test
	public void addUserAPI() {
		Response response = user.LoginToApplication();
	
		Response response1= user.addUser(response);
		reusable.getValidStatusCode(response1);
		
		
		response1.then().statusCode(201);
		String contant_type=reusable.getContentType(response1);
		System.out.println("the content type "+contant_type);
		
		

}
}
