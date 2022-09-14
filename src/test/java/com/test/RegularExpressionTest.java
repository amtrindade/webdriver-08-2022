package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class RegularExpressionTest extends BaseTest{
	
	@Before
	public void setUp() throws Exception {
		getDriver().get("https://www.geradordecpf.org/");		
	}
		
	@Test
	public void testValidateCpfWithDot() throws InterruptedException {
		WebElement cbPontos = getDriver().findElement(By.id("cbPontos"));
		cbPontos.click();
		
		WebElement btnGerar = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerar.click();
		
		WebElement tfCpf = getDriver().findElement(By.id("numero"));
		
		String cpfGerado = tfCpf.getAttribute("value");		
		
		System.out.println(cpfGerado);
		
		assertTrue(cpfGerado.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$"));
		
	}

}
