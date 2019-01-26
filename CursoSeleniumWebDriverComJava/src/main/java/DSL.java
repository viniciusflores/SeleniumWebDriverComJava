import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	private WebDriver driver;
	
	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escreveComIdCampo(String id_campo, String texto) {
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	public String obterValorCampo(String id_campo) {
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	public void clicarComIdCampo (String id_campo) {
		driver.findElement(By.id(id_campo)).click();
	}
	
	public boolean estaCampoMarcado(String id_campo) {
		return driver.findElement(By.id(id_campo)).isSelected();
	}
	
	public void selecionarCombo(String id_campo, String valor) {
		WebElement elemento = driver.findElement(By.id(id_campo));
		Select combo = new Select(elemento);
		combo.selectByVisibleText(valor);
	}

	public String obterValorCombo(String id_campo) {
		WebElement elemento = driver.findElement(By.id(id_campo));
		Select combo = new Select(elemento);
		return combo.getFirstSelectedOption().getText();
	}

	public String obterTexto(By by) {
		return driver.findElement(by).getText();
	}
	
	
	public String obterTexto(String id) {
		return driver.findElement(By.id(id)).getText();
	}
	
	

}
