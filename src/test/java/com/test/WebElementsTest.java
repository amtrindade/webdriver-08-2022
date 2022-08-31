package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementsTest {
	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/home/antonio/dev/drivers/chromedriver"); 
		//C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();		
		driver.get("http://antoniotrindade.com.br/treinoautomacao/elementsweb.html");		

	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();	
	}

	@Test
	public void testValidateNameTextField() {
		//mapeia o elemento
		WebElement textFieldName = driver.findElement(By.name("txtbox1"));
		
		//faz a interação com o elemento
		textFieldName.sendKeys("Antonio Trindade");
		
		//valida o resultado
		assertEquals("Antonio Trindade", textFieldName.getAttribute("value"));		
	}
	
}
