import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

	private WebDriver driver;
	private DSL dsl;
	
	@Before
	public void inicializa(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}
		
	@Test
	public void deveInteragirComAlertSimples() {
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
		
		dsl.clicarBotao("confirm");
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
	}
	
	@Test
	public void deveInteragirComAlertConfirm() {
		WebElement btnAlert = driver.findElement(By.id("confirm"));
		btnAlert.click();
		Alert alerta = driver.switchTo().alert();
		alerta.accept();
		String texto = alerta.getText();
		Assert.assertEquals("Confirmado", texto);
		alerta.accept();
		texto = "";
		
		btnAlert.click();
		alerta = driver.switchTo().alert();
		alerta.dismiss();
		texto = alerta.getText();
		Assert.assertEquals("Negado", texto);
		alerta.accept();
		
	}
	
	@Test
	public void deveInteragirComAlertPrompt() {
		dsl.clicarBotao("prompt");
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
		
	}
		
}
