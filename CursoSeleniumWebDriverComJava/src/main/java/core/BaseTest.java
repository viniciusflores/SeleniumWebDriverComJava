package core;

import static core.DriverFactory.killDriver;

import org.junit.After;

public class BaseTest {

	@After
	public void finaliza(){
		if(Propiedades.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
