package com.test.tests;

import org.testng.annotations.Test;

import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class LoginToApiTest {

	UserServiceHelper user = new UserServiceHelper();
	ReusableMethods reusable=new ReusableMethods();

	@Test
	public void loginAPI() {
		Response response = user.LoginToApplication();
		reusable.getValidStatusCode(response);
		
		String token = user.getToken(response);
		System.out.println("The Login Token :" + token);
		response.then().statusCode(201);
		String contant_type=reusable.getContentType(response);
		System.out.println("the content type "+contant_type);
		
	}
	

}
