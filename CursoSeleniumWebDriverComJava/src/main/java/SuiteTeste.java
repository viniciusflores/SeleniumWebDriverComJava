import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastroComSucesso.class,
	TesteRegrasCadastro.class,
	TesteCampoTreinamento.class,
	TesteFormulario.class
})
public class SuiteTeste {

}
