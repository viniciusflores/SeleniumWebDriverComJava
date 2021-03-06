package test;
import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.BaseTest;
import core.DSL;

public class TesteAjax extends BaseTest{
	private DSL dsl;

	@BeforeTest
	public void inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}
	
	@Test
	public void testAjax() {
		dsl.escrever("j_idt694:name", "firmizinho");
		dsl.clicarBotao("j_idt694:j_idt697");
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt694:display"), "firmizinho"));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt709")));
		Assert.assertEquals("firmizinho", dsl.obterTexto("j_idt694:display"));
	}
}
