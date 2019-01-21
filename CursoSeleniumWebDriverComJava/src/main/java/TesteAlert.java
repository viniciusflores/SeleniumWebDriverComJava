import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

	@Test
	public void testeAlertSimples() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		WebElement btnAlert = driver.findElement(By.id("alert"));
		btnAlert.click();
		Alert alerta = driver.switchTo().alert();
		String texto = alerta.getText();
		Assert.assertEquals("Alert Simples", texto);
		alerta.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
		driver.quit();
	}
	
	@Test
	public void testAlertaConfirma() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
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
		driver.quit();
	}
	
	@Test
	public void testAlertaPrompt() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		WebElement btnPrompt = driver.findElement(By.id("prompt"));
		btnPrompt.click();
		
		Alert alerta = driver.switchTo().alert();
		String txt = alerta.getText();
		Assert.assertEquals("Digite um numero", txt);
		alerta.sendKeys("21");
		alerta.accept();
		txt = alerta.getText();
		Assert.assertEquals("Era 21?", txt);
		alerta.accept();
		txt = alerta.getText();
		Assert.assertEquals(":D", txt);
		alerta.accept();
		
		driver.quit();
		
	}
		
}
