package com.test;

import static org.junit.Assert.*;

import java.util.List;

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
		WebElement tfName = driver.findElement(By.cssSelector("*[name='txtbox1']"));
		
		//faz a interação com o elemento
		tfName.sendKeys("Antonio Trindade");
		
		//valida o resultado
		assertEquals("Antonio Trindade", tfName.getAttribute("value"));		
	}
	
	@Test
	public void testValidadeEnableTextFields() {
		
		WebElement tfBox1 = driver.findElement(By.name("txtbox1"));
		WebElement tfBox2 = driver.findElement(By.name("txtbox2"));
		
		assertFalse(tfBox2.isEnabled());
		assertTrue(tfBox1.isEnabled());

	}
	
	@Test
	public void testValidateRadioGroup1() throws InterruptedException {
		
		List<WebElement> listRadio = driver.findElements(By.name("radioGroup1"));
		listRadio.get(2).click();
		
		Thread.sleep(5000);
		
		assertFalse(listRadio.get(0).isSelected());
		assertFalse(listRadio.get(1).isSelected());
		assertTrue(listRadio.get(2).isSelected());
		assertFalse(listRadio.get(3).isSelected());
		
	}
	
}
