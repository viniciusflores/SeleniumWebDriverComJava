package Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.TesteCadastroComSucesso;
import test.TesteCampoTreinamento;
import test.TesteFormulario;
import test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastroComSucesso.class,
	TesteRegrasCadastro.class,
	TesteCampoTreinamento.class,
	TesteFormulario.class
})
public class SuiteTeste {

}
