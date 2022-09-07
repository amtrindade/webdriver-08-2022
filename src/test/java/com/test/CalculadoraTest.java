package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculadoraTest {
	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/home/antonio/dev/drivers/chromedriver"); 
		//C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get("http://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");		

	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();	
	}

	@Test
	public void testSoma() {
		
	}
	
	

}
