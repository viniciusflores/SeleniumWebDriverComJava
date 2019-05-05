package Core;

import static Core.DriverFactory.killDriver;

import java.io.IOException;

import org.testng.annotations.AfterClass;

public class BaseTest {
	
	/*@Rule
	public TestName testNome = new TestName();
	*/
	@AfterClass
	public void finaliza() throws IOException{
		/*TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot"  
				+ File.separator + testNome.getMethodName() + ".jpg"));
		*/
		if(Propiedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
