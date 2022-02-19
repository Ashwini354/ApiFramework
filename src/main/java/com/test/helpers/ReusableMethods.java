package com.test.helpers;

import io.restassured.response.Response;

public class ReusableMethods {

	public int getValidStatusCode(Response response) {
		return response.statusCode();
	}
	
	public String getContentType(Response response1) {
		return response1.contentType();
	}
	public String getPrettyPrint(Response response2) {
		return response2.prettyPrint();
	}
	
	
}
