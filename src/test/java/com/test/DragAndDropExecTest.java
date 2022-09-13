package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.core.BaseTest;

public class DragAndDropExecTest extends BaseTest {
	
	@Before
	public void setUp() throws Exception {
		getDriver().get("http://sahitest.com/demo/dragDropMooTools.htm");		
	}
	
	
	@Test
	public void testValidateItems() {
		WebElement source = getDriver().findElement(By.id("dragger"));
		
		WebElement item1 = getDriver().findElement(By.xpath("//*[.='Item 1']"));
		WebElement item4 = getDriver().findElement(By.xpath("//*[.='Item 4']"));
		
		assertEquals("Item 1", item1.getText());
		assertEquals("Item 4", item4.getText());
		
		new Actions(getDriver()).dragAndDrop(source, item1).perform();
		assertEquals("dropped", item1.getText());
		
		new Actions(getDriver()).dragAndDrop(source, item4).perform();
		assertEquals("dropped", item4.getText());
	}

}
