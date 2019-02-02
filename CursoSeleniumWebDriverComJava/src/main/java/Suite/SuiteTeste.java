package Suite;
import static core.DriverFactory.killDriver;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.DriverFactory;
import test.TesteCadastroComSucesso;
import test.TesteCampoTreinamento;
import test.TesteFormulario;
import test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastroComSucesso.class,
	TesteRegrasCadastro.class,

})
public class SuiteTeste {
	
	@AfterClass
	public static void finalizaTudo() {
		killDriver();
	}
	
}
