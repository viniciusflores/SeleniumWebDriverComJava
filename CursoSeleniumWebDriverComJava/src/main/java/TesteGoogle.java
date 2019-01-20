import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	@Test
	public void teste() {
		
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		driver.get("http://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		
	}	
}