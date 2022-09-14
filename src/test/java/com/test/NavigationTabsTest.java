package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class NavigationTabsTest extends BaseTest {	

	@Before
	public void setUp() throws Exception {
		getDriver().get("http://antoniotrindade.com.br/treinoautomacao/index.html");		
	}
	
	@Test
	public void testNavigationTabs() {
		//valida o título da página
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		//mapeia o elemento
		WebElement linkGcpf = getDriver().findElement(By.linkText("Gerador de CPF"));
		linkGcpf.click();
		
		//cria um arrayList com as tabs abertas
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		//navega o foco do getDriver() para a tab que se deseja interagir
		getDriver().switchTo().window(tabs.get(1));
		
		//valida o título da nova página numa nova tab
		assertEquals("Gerador de CPF", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
	}

}
