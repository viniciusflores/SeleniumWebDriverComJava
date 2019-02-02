import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import core.DSL;

public class TestePrime {
	private DSL dsl;

	@Before
	public void inicializa(){
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl = new DSL();
		new CampoTreinamentoPage();
	}
	
	@After
	public void finaliza(){
		killDriver();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		//dsl.clicarRadio(By.xpath("input[@id='j_idt695:console:0']/../..//span"));
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt695:console:1"));
	}
	
	@Test
	public void deveInteragirComComboPrime() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.clicarRadio(By.xpath(".//*[@id='j_idt695:console_input']/../..//span"));
		dsl.clicarRadio(By.xpath(".//*[@id='j_idt695:console_items']//li[.='PS4']"));
		Assert.assertEquals("PS4", dsl.obterTexto("j_idt695:console_label"));
	}
	
}
