package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.core.BaseTest;
import com.page.LoginPage;


public class LoginTest extends BaseTest{
	
	@Test
	public void testPasswordInvalid() {
		
		LoginPage loginPage = new LoginPage();
		loginPage.open();
		loginPage.enterUsername("test");
		loginPage.enterPassword("x1234dfsfdsf");
		loginPage.submitInvalid();
		
		assertEquals("Invalid username or password", 
				loginPage.getMessageError());				
	}

}
