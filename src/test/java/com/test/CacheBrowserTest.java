package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class CacheBrowserTest extends BaseTest{
	

	@Before
	public void setUp() throws Exception {		
		getDriver().get("http://antoniotrindade.com.br/treinoautomacao");		
	}	
		
	@Test
	public void testNavigationCache() {
		
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		WebElement menuCalculadora = getDriver().findElement(By.linkText("Calculadora"));
		menuCalculadora.click();	
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		WebElement menuTable = getDriver().findElement(By.linkText("Localizar Table"));
		menuTable.click();		
		assertEquals("Trabalhando com tables", getDriver().getTitle());
		
		//validar que estou na calculadora
		getDriver().navigate().back();
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		//validar que estou na home
		getDriver().navigate().back();		
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		//validar qu estou na calculadora
		getDriver().navigate().forward();
		assertEquals("Desafio Automação Cálculos", getDriver().getTitle());
		
		//validar que estou na tables
		getDriver().navigate().forward();
		assertEquals("Trabalhando com tables", getDriver().getTitle());
	}

	

}
