package core;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;



public class BaseTest {

	ITestContext testContext;
	
	@AfterMethod
	public void finaliza() throws IOException{
		TakesScreenshot ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot"  
				+ File.separator + testContext.getName() + ".jpg"));
		
		if(Propiedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
