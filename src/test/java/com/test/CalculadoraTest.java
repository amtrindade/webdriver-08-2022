package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculadoraTest {
	private WebDriver driver;
	private WebElement tfOne;
	private WebElement tfTwo;
	private WebElement tfTotal;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/antonio/dev/drivers/chromedriver");
		// C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");

		tfOne = driver.findElement(By.id("number1"));
		tfTwo = driver.findElement(By.id("number2"));
		tfTotal = driver.findElement(By.id("total"));

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testSoma() throws InterruptedException {
		// mapeia os componentes
		WebElement btnSum = driver.findElement(By.id("somar"));

		// interage com os valores
		tfOne.sendKeys("4");
		tfTwo.sendKeys("5");
		btnSum.click();

		//Espera por um texto no textfield estar presente
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.textToBePresentInElementValue(By.id("total"), "9"));

		// valida o resultado
		assertEquals("9", tfTotal.getAttribute("value"));
	}

	@Test
	public void testSubtracao() {
		// mapeia os componentes
		WebElement btnMinus = driver.findElement(By.id("subtrair"));

		// interage com os valores
		tfOne.sendKeys("10");
		tfTwo.sendKeys("4");
		btnMinus.click();

		// valida o resultado
		assertEquals("6", tfTotal.getAttribute("value"));
	}

	@Test
	public void testMultiplica() {
		WebElement btnMultiplicacao = driver.findElement(By.id("multiplicar"));

		// interage com os valores
		tfOne.sendKeys("10");
		tfTwo.sendKeys("4");
		btnMultiplicacao.click();

		// valida o resultado
		assertEquals("40", tfTotal.getAttribute("value"));
	}

}
