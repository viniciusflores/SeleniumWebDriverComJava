import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastroComSucesso {
	@Test
	public void testCadastroComSucesso() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		Assert.assertEquals("Campo de Treinamento", driver.getTitle());
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Vinicius");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Flores");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Select comboAula = new Select(driver.findElement(By.id("elementosForm:escolaridade")));
		comboAula.selectByVisibleText("Superior");
		Select comboEsporte = new Select(driver.findElement(By.id("elementosForm:esportes")));
		comboEsporte.selectByVisibleText("Futebol");
		comboEsporte.selectByVisibleText("Corrida");
		driver.findElement(By.id("elementosForm:cadastrar")).click();

		Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
		Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Vinicius"));
		Assert.assertTrue(driver.findElement(By.id("descSobrenome")).getText().endsWith("Flores"));
		Assert.assertTrue(driver.findElement(By.id("descSexo")).getText().endsWith("Masculino"));
		Assert.assertTrue(driver.findElement(By.id("descComida")).getText().endsWith("Carne"));
		Assert.assertTrue(driver.findElement(By.id("descEscolaridade")).getText().endsWith("superior"));
		Assert.assertTrue(driver.findElement(By.id("descEsportes")).getText().endsWith("Futebol Corrida"));
		Assert.assertEquals("Sugestoes:", driver.findElement(By.id("descSugestoes")).getText());

		driver.quit();

	}
}
