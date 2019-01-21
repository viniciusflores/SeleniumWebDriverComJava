import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	@Test
	public void testeTextField() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("elementosForm:nome")).sendKeys("Vili");
		Assert.assertEquals("Vili", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}

	@Test
	public void testeTextArea() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement txtSugestoes = driver.findElement(By.id("elementosForm:sugestoes"));
		txtSugestoes.sendKeys("Vili\ncius\nFlores");
		Assert.assertEquals("Vili\ncius\nFlores", txtSugestoes.getAttribute("value"));
		driver.quit();
	}

	@Test
	public void testeRadioButton() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement radBtn = driver.findElement(By.id("elementosForm:sexo:0"));
		radBtn.click();
		Assert.assertTrue(radBtn.isSelected());
		driver.quit();
	}

	@Test
	public void testeCheckBox() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement checkPizza = driver.findElement(By.id("elementosForm:comidaFavorita:2"));
		checkPizza.click();
		Assert.assertTrue(checkPizza.isSelected());
		driver.quit();
	}

	@Test
	public void testeCombo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		Select comboEscola = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
		// comboEscola.selectByIndex(3);
		// comboEscola.selectByValue("1graucomp");
		comboEscola.selectByVisibleText("Superior");

		Assert.assertEquals("Superior", comboEscola.getFirstSelectedOption().getText());
		driver.quit();
	}

	@Test
	public void testeCombo2() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

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

		driver.quit();
	}

	@Test
	public void testeComboMultiplo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("Karate");

		List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectOptions.size());

		driver.quit();
	}

	@Test
	public void testeBotoes() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement btnClick = driver.findElement(By.id("buttonSimple"));
		btnClick.click();

		Assert.assertEquals("Obrigado!", btnClick.getAttribute("value"));

		driver.quit();
	}

	@Test
	@Ignore
	public void testeLink() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement link = driver.findElement(By.linkText("Voltar"));
		link.click();

		// Assert.assertEquals("Voltou!",
		// driver.findElement(By.id("resultado")).getText());
		// Assert.fail();
		driver.quit();
	}

	@Test
	public void testeBuscaTextoNaTela() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));

		driver.quit();
	}

}
