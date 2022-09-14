package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.BaseTest;

public class CalculadoraTest extends BaseTest{
	
	private WebElement tfOne;
	private WebElement tfTwo;
	private WebElement tfTotal;

	@Before
	public void setUp() throws Exception {
		getDriver().get("http://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");

		tfOne = getDriver().findElement(By.id("number1"));
		tfTwo = getDriver().findElement(By.id("number2"));
		tfTotal = getDriver().findElement(By.id("total"));

	}
	

	@Test
	public void testSoma() throws InterruptedException {
		// mapeia os componentes
		WebElement btnSum = getDriver().findElement(By.id("somar"));

		// interage com os valores
		tfOne.sendKeys("4");
		tfTwo.sendKeys("5");
		btnSum.click();

		//Espera por um texto no textfield estar presente
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions
				.textToBePresentInElementValue(By.id("total"), "9"));

		// valida o resultado
		assertEquals("9", tfTotal.getAttribute("value"));
	}

	@Test
	public void testSubtracao() {
		// mapeia os componentes
		WebElement btnMinus = getDriver().findElement(By.id("subtrair"));

		// interage com os valores
		tfOne.sendKeys("10");
		tfTwo.sendKeys("4");
		btnMinus.click();

		// valida o resultado
		assertEquals("6", tfTotal.getAttribute("value"));
	}

	@Test
	public void testMultiplica() {
		WebElement btnMultiplicacao = getDriver().findElement(By.id("multiplicar"));

		// interage com os valores
		tfOne.sendKeys("10");
		tfTwo.sendKeys("4");
		btnMultiplicacao.click();

		// valida o resultado
		assertEquals("40", tfTotal.getAttribute("value"));
	}

}
