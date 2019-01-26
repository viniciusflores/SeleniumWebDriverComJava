import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

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
	public void testeTextField() {
		dsl.escreveComIdCampo("elementosForm:nome", "Vili");
		Assert.assertEquals("Vili", dsl.obterValorCampo("elementosForm:nome"));

	}

	@Test
	public void testeTextArea() {
		dsl.escreveComIdCampo("elementosForm:sugestoes", "Vili\ncius\nFlores");
		Assert.assertEquals("Vili\ncius\nFlores", dsl.obterValorCampo("elementosForm:sugestoes"));

	}

	@Test
	public void testeRadioButton() {
		dsl.clicarComIdCampo("elementosForm:sexo:0");
		Assert.assertTrue(dsl.estaCampoMarcado("elementosForm:sexo:0"));
	}

	@Test
	public void testeCheckBox() {
		dsl.clicarComIdCampo("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.estaCampoMarcado("elementosForm:comidaFavorita:2"));		
	}

	@Test
	public void testeCombo() {
		dsl.selecionarCombo("elementosForm:escolaridade", "Superior");
		Assert.assertEquals("Superior", dsl.obterValorCombo("elementosForm:escolaridade"));
	}

	@Test
	public void testeCombo2() {
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());

		boolean encontrou = false;
		for (WebElement option : options) {
			if (option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);

	}

	@Test
	public void testeComboMultiplo() {
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("Karate");

		List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectOptions.size());

	}

	@Test
	public void testeBotoes() {
		dsl.clicarComIdCampo("buttonSimple");

		Assert.assertEquals("Obrigado!", dsl.obterValorCampo("buttonSimple"));

	}

	@Test
	@Ignore
	public void testeLink() {
		WebElement link = driver.findElement(By.linkText("Voltar"));
		link.click();

		// Assert.assertEquals("Voltou!",
		// driver.findElement(By.id("resultado")).getText());
		// Assert.fail();

	}

	@Test
	public void testeBuscaTextoNaTela() {
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
		
	}
}
