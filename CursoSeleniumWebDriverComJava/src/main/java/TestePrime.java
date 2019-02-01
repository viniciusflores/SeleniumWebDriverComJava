import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePrime {
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		//dsl.clicarRadio(By.xpath("input[@id='j_idt695:console:0']/../..//span"));
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt695:console:1"));
	}
	
	@Test
	public void deveInteragirComComboPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.clicarRadio(By.xpath(".//*[@id='j_idt695:console_input']/../..//span"));
		dsl.clicarRadio(By.xpath(".//*[@id='j_idt695:console_items']//li[.='PS4']"));
		Assert.assertEquals("PS4", dsl.obterTexto("j_idt695:console_label"));
	}
	
}
