package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropExecTest {
	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/home/antonio/dev/drivers/chromedriver"); 		
		driver = new ChromeDriver();			
		driver.get("http://sahitest.com/demo/dragDropMooTools.htm");		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();	
	}
	
	@Test
	public void testValidateItems() {
		WebElement source = driver.findElement(By.id("dragger"));
		
		WebElement item1 = driver.findElement(By.cssSelector("body > div:nth-child(4)"));
		WebElement item4 = driver.findElement(By.cssSelector("body > div:nth-child(7)"));
		
		assertEquals("Item 1", item1.getText());
		assertEquals("Item 4", item4.getText());
		
		new Actions(driver).dragAndDrop(source, item1).perform();
		assertEquals("dropped", item1.getText());
		
		new Actions(driver).dragAndDrop(source, item4).perform();
		assertEquals("dropped", item4.getText());
	}

}
