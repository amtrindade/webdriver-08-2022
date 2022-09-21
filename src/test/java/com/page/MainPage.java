package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public MainPage open() {
		getDriver().get("https://en.wikipedia.org/");		
		return this;
	}
	
	public ArticlePage search(String country) {
		//textfield pesquisa
		WebElement tfSearchInput = getDriver().findElement(By.id("searchInput"));
		tfSearchInput.sendKeys(country);
		
		//botão de lupa (lupinha)
		WebElement btnSearch = getDriver().findElement(By.id("searchButton"));
		btnSearch.click();
		
		return new ArticlePage();
	}

}
