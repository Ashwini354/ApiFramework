package com.test.helpers;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.constant.EndPoints;
import com.test.models.AddUserPOJO;
import com.test.models.DeleteUserPOJO;
import com.test.models.LoginObjectPOJO;
import com.test.models.UpdateUserPOJO;
import com.test.utils.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class UserServiceHelper {

	public Response LoginToApplication() {
		String username = Utils.getValues("username");
		String password = Utils.getValues("password");
		LoginObjectPOJO ob = new LoginObjectPOJO(username, password);
		Response res = RestAssured.given().contentType(ContentType.JSON).body(ob).when()
				.post(Utils.getValues("baseURL") + EndPoints.LOGIN);
		return res;
	}

	public String getToken(Response res) {
		res = LoginToApplication();
		return res.jsonPath().get("[0].token");

	}
	
	public Response getAllUser(Response res1) {
		 String token=getToken(res1);
		Header header1 = new Header("token", token);
		Response res = RestAssured.given().header(header1).when()
				.get(Utils.getValues("baseURL")+EndPoints.GET_DATA);
		
		return res;
		
	}
	public Response addUser(Response res) {
		String acc = Utils.getValues("acc_no");
		String dept = Utils.getValues("dept_no");
		String salary = Utils.getValues("salary");
		String pincode = Utils.getValues("pincode");
		
		AddUserPOJO add=new AddUserPOJO(acc, dept, salary, pincode);
		String token=getToken(res);
		Header header1 = new Header("token", token);
		
		Response response=RestAssured.given().header(header1).contentType(ContentType.JSON)
				.body(add)
			.when().post(Utils.getValues("baseURL")+EndPoints.ADD_DATA);
		
		
		
		return response;
		
	}
	
	public Response updateUser(Response res) {
		String acc = Utils.getValues("acc_no");
		String dept = Utils.getValues("update_dept_no");
		String salary = Utils.getValues("salary");
		String pincode = Utils.getValues("pincode");
		String userid = Utils.getValues("update_userid");
		String id = Utils.getValues("update_dept_no");
		UpdateUserPOJO update=new UpdateUserPOJO(acc, dept, salary, pincode, userid, id);
		String token=getToken(res);
		Header header1 = new Header("token", token);
		Response response=RestAssured.given().header(header1).contentType(ContentType.JSON)
				.body(update)
				.when().put(Utils.getValues("baseURL")+EndPoints.UPDATE_DATE);
		
		//System.out.print(response.jsonPath().get("status"));
		return response;
	}
	
	public Response deleteUser(Response res) {
		String userid = Utils.getValues("update_userid");
		String id = Utils.getValues("update_dept_no");
		DeleteUserPOJO delete=new DeleteUserPOJO(userid,id);
		String token=getToken(res);
		Header header1 = new Header("token", token);
		Response response=RestAssured.given().header(header1).contentType(ContentType.JSON).body(delete).when()
				.delete(Utils.getValues("baseURL")+EndPoints.DELETE_DATA);
		
		//System.out.println(response.jsonPath().get("status"));
		return response;
}
}