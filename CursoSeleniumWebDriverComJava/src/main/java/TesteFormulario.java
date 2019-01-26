import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteFormulario {
	
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
	public void validaNomeObrigatorio() {
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		String txt = alerta.getText();
		Assert.assertEquals("Nome eh obrigatorio", txt);
	}

	@Test
	public void validaSobrenomeObrigatorio() {
		dsl.escreveComIdCampo("elementosForm:nome", "Nome");
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		String txt = alerta.getText();
		Assert.assertEquals("Sobrenome eh obrigatorio", txt);
	}
	
	@Test
	public void validaSexoObrigatorio() {
		dsl.escreveComIdCampo("elementosForm:nome", "Nome");
		dsl.escreveComIdCampo("elementosForm:sobrenome", "Silva");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		String txt = alerta.getText();
		Assert.assertEquals("Sexo eh obrigatorio", txt);
	}

	@Test
	public void validaVegetariano() {
		dsl.escreveComIdCampo("elementosForm:nome", "Nome");
		dsl.escreveComIdCampo("elementosForm:sobrenome", "Silva");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		String txt = alerta.getText();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", txt);
	}
	
	@Test
	public void validaEsporte() {
		dsl.escreveComIdCampo("elementosForm:nome", "Nome");
		dsl.escreveComIdCampo("elementosForm:sobrenome", "Silva");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByIndex(0);
		combo.selectByIndex(1);
		combo.selectByIndex(2);
		combo.selectByIndex(3);
		combo.selectByIndex(4);
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alerta = driver.switchTo().alert();
		String txt = alerta.getText();
		Assert.assertEquals("Voce faz esporte ou nao?", txt);
	}
	
}
