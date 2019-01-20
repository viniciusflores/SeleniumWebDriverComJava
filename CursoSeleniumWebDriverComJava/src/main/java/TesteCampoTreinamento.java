import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
	
}
