package com.test.tests;

import org.testng.annotations.Test;

import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;

import io.restassured.response.Response;
@Test
public class GetUserDataTest2 {
	UserServiceHelper user = new UserServiceHelper();
	ReusableMethods reusable=new ReusableMethods();
	public void getData() {
		Response response_login = user.LoginToApplication();
		Response res_get_data=user.getAllUser(response_login);
		reusable.getPrettyPrint(res_get_data);
		System.out.println("\n");
		System.out.println(" status code  "+reusable.getValidStatusCode(res_get_data));
	}

}
