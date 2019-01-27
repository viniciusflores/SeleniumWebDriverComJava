import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastroComSucesso {
	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa(){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}
	
	@After
	public void finaliza(){
		driver.quit();
	}

	@Test
	public void deveRealizarCadastroComSucesso(){
		page.setNome("Wagner");
		page.setSobrenome("Costa");
		page.setSexoMasculino();
		page.setComidaFavPizza();
		page.setEscolaridade("Mestrado");
		page.setEsportes("Natacao");
		page.cadastrar();
		
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterResultadoNome().endsWith("Wagner"));
		Assert.assertEquals("Sobrenome: Costa", page.obterResultadoSobrenome());
		Assert.assertEquals("Sexo: Masculino", page.obterResultadoSexo());
		Assert.assertEquals("Comida: Pizza", page.obterResultadoComida());
		Assert.assertEquals("Escolaridade: mestrado", page.obterResultadoEscolaridade());
		Assert.assertEquals("Esportes: Natacao", page.obterResultadoEsportes());
	}
	
}
