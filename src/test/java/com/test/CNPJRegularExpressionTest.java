package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.BaseTest;

public class CNPJRegularExpressionTest extends BaseTest{
	

	@Before
	public void setUp() throws Exception {	
		getDriver().get("https://www.4devs.com.br/gerador_de_cnpj");		
	}
		
	@Ignore
	@Test
	public void testValidateCNPJWithMak() throws InterruptedException {
		WebElement btnGerar = getDriver().findElement(By.id("bt_gerar_cnpj"));
		btnGerar.click();
		
		WebElement divCnpj = getDriver().findElement(By.id("texto_cnpj"));
		
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions
				.invisibilityOfElementWithText(By.id("texto_cnpj"), "Gerando..."));
		
		String cnpjGerado = divCnpj.getText();
		System.out.println(cnpjGerado);
	
		assertTrue(cnpjGerado.matches("^\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}$"));
	}
	
	@Ignore
	@Test
	public void testValidateCNPJWhithoutMask() throws InterruptedException {
		WebElement checkNo = getDriver().findElement(By.id("pontuacao_nao"));
		checkNo.click();
		
		WebElement btnGerar = getDriver().findElement(By.id("bt_gerar_cnpj"));
		btnGerar.click();
		
		WebElement divCnpj = getDriver().findElement(By.id("texto_cnpj"));
		
		Thread.sleep(15000);
		
		String cnpjGerado = divCnpj.getText();
		System.out.println(cnpjGerado);
	
		assertTrue(cnpjGerado.matches("^\\d{14}$"));
		
	}


}
