package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CNPJRegularExpressionTest {
	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/home/antonio/dev/drivers/chromedriver"); 		
		driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.get("https://www.4devs.com.br/gerador_de_cnpj");		
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();	
	}
	
	@Test
	public void testValidateCNPJWithMak() throws InterruptedException {
		WebElement btnGerar = driver.findElement(By.id("bt_gerar_cnpj"));
		btnGerar.click();
		
		WebElement divCnpj = driver.findElement(By.id("texto_cnpj"));
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.invisibilityOfElementWithText(By.id("texto_cnpj"), "Gerando..."));
		
		String cnpjGerado = divCnpj.getText();
		System.out.println(cnpjGerado);
	
		assertTrue(cnpjGerado.matches("^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$"));
	}
	
	@Test
	public void testValidateCNPJWhithoutMask() throws InterruptedException {
		WebElement checkNo = driver.findElement(By.id("pontuacao_nao"));
		checkNo.click();
		
		WebElement btnGerar = driver.findElement(By.id("bt_gerar_cnpj"));
		btnGerar.click();
		
		WebElement divCnpj = driver.findElement(By.id("texto_cnpj"));
		
		Thread.sleep(15000);
		
		String cnpjGerado = divCnpj.getText();
		System.out.println(cnpjGerado);
	
		assertTrue(cnpjGerado.matches("^\\d{14}$"));
		
	}


}
