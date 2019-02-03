package Core;

import static Core.DriverFactory.getDriver;
import static Core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Pages.LoginPage;

public class BaseTest {
	
	private LoginPage page = new LoginPage();
	
	@Rule
	public TestName testNome = new TestName();
	
	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		page.logarNoSistema("testeselenium@udemy.com", "helloworld");
	}

	
	@After
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot"  
				+ File.separator + testNome.getMethodName() + ".jpg"));
		
		if(Propiedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
