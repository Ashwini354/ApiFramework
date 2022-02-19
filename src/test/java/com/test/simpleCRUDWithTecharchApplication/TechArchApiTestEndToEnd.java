package com.test.simpleCRUDWithTecharchApplication;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.test.tests.AddUserDataTest;
import com.test.tests.DeleteUserDataTest2;
import com.test.tests.GetUserDataTest2;
import com.test.tests.UpdateUserDataTest;

public class TechArchApiTestEndToEnd {
	
	AddUserDataTest add=new AddUserDataTest();
	GetUserDataTest2 get=new GetUserDataTest2();
	UpdateUserDataTest update=new UpdateUserDataTest();
	DeleteUserDataTest2 delete=new DeleteUserDataTest2();
	@Test
	public void allTest() {
		add.addUserAPI();
		get.getData();
		update.UpdateUserAPI();
		delete.UpdateUserAPI();
	}
	
	
	
		
		
		
	}


