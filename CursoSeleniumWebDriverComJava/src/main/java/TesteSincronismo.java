import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteSincronismo {
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dsl.escrever("novoCampo", "Deu certo?");
		Assert.assertEquals("Deu certo?", dsl.obterTexto("novoCampo"));
	}
	
	@Test
	public void deveUtilizarEsperaExplicita() throws InterruptedException {
		dsl.clicarBotao("buttonDelay");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Deu certo?");
		Assert.assertEquals("Deu certo?", dsl.obterTexto("novoCampo"));
	}


}
