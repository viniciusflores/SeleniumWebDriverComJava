package test;
import static core.DriverFactory.getDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.BaseTest;
import core.DSL;

public class TesteSincronismo extends BaseTest{
	private DSL dsl;

	@BeforeClass
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	@Test
	public void deveUtilizarEsperaFixa() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		Thread.sleep(10000);
		dsl.escrever("novoCampo", "Deu certo?");
		Assert.assertEquals("Deu certo?", dsl.obterTexto("novoCampo"));
	}
	
	@Test
	public void deveUtilizarEsperaImplicita() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dsl.escrever("novoCampo", "Deu certo?");
		Assert.assertEquals("Deu certo?", dsl.obterTexto("novoCampo"));
	}
	
	@Test
	public void deveUtilizarEsperaExplicita() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Deu certo?");
		Assert.assertEquals("Deu certo?", dsl.obterTexto("novoCampo"));
	}


}
