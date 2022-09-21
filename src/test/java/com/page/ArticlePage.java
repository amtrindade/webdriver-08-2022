package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {
	
	public String getH1Text() {
		WebElement titleH1 = getDriver().findElement(By.xpath("//h1[@id='firstHeading']/span"));		
		return titleH1.getText();
	}

}
