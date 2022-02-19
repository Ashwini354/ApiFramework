package com.test.tests;

import org.testng.annotations.Test;

import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;

import io.restassured.response.Response;

public class UpdateUserDataTest {
	
	UserServiceHelper user = new UserServiceHelper();
	ReusableMethods reusable=new ReusableMethods();

	@Test
	public void UpdateUserAPI() {
		Response response = user.LoginToApplication();
	
		Response response1= user.updateUser(response);
		reusable.getValidStatusCode(response1);
		
		
		response1.then().statusCode(200);
		String contant_type=reusable.getContentType(response1);
		System.out.println("the content type "+contant_type);

}
}
